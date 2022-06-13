package ru.flendger.school.puzzler.students.model.service.lessonlogin;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.settings.StudentLessonKeyBeforeTimeSetting;
import ru.flendger.school.puzzler.students.model.dao.LessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentStorageService;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.entity.Student;
import ru.flendger.school.puzzler.students.model.entity.StudentLesson;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginRequest;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginStudentDto;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.KeyNotFoundException;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.LessonLoginExceptionHandler;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.StudentAlreadyLoginException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonLoginServiceImpl implements LessonLoginService {
    private final LessonKeyStorageService lessonKeyStorageService;
    private final DateTimeService dateTimeService;
    private final StudentStorageService studentStorageService;
    private final ModelMapper studentsModelMapper;
    private final LessonLoginExceptionHandler exceptionHandler;
    private final StudentLessonStorageService studentLessonStorageService;
    private final StudentLessonKeyStorageService studentLessonKeyStorageService;
    private final ApplicationSettingsService applicationSettingsService;

    @Override
    @Transactional
    public List<LessonLoginStudentDto> findStudentsByLessonKey(String keyValue) {
        Optional<LessonKey> optionalLessonKey = lessonKeyStorageService.findActive(keyValue, dateTimeService.current());
        if (optionalLessonKey.isEmpty()) {
            return Collections.emptyList();
        }

        LessonKey lessonKey = optionalLessonKey.get();
        return studentStorageService
                .findBySchoolClass(lessonKey.getSchoolClassId())
                .stream()
                .map(student -> studentsModelMapper.map(student, LessonLoginStudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void login(LessonLoginRequest loginRequest) throws KeyNotFoundException, StudentAlreadyLoginException, EntityNotFoundException {
        LocalDateTime loginDate = dateTimeService.current();

        String keyValue = loginRequest.getKeyValue();
        LessonKey lessonKey = checkAndGetLessonKey(loginDate, keyValue);

        checkStudentAlreadyLogin(loginDate, loginRequest);

        Long studentId = loginRequest.getStudentId();
        Student student = checkAndGetStudent(studentId);

        Long lessonId = lessonKey.getLessonId();
        StudentLessonKey studentLessonKey = StudentLessonKey
                .builder()
                .keyValue(keyValue)
                .loginDate(loginDate)
                .studentId(studentId)
                .build();
        studentLessonKeyStorageService.save(studentLessonKey);

        StudentLesson studentLesson = StudentLesson
                .builder()
                .student(student)
                .lessonId(lessonId)
                .startedAt(loginDate)
                .build();
        studentLessonStorageService.save(studentLesson);
    }

    private LessonKey checkAndGetLessonKey(LocalDateTime loginDate, String keyValue) throws KeyNotFoundException {
        return lessonKeyStorageService
                .findActive(keyValue, loginDate)
                .orElseThrow(() -> exceptionHandler.keyNotValid(keyValue));
    }

    private Student checkAndGetStudent(Long studentId) throws EntityNotFoundException {
        return studentStorageService.findById(studentId)
                .orElseThrow(() -> exceptionHandler.studentNotFound(studentId));
    }

    private void checkStudentAlreadyLogin(LocalDateTime loginDate, LessonLoginRequest loginRequest) throws StudentAlreadyLoginException {
        StudentLessonKeyBeforeTimeSetting lessonKeyBeforeTimeSetting = applicationSettingsService.getSetting(StudentLessonKeyBeforeTimeSetting.class);

        String keyValue = loginRequest.getKeyValue();
        Long studentId = loginRequest.getStudentId();
        Optional<StudentLessonKey> optionalStudentLessonKey =
                studentLessonKeyStorageService.findActiveLoginKey(keyValue,
                        studentId,
                        loginDate.minusHours(lessonKeyBeforeTimeSetting.getValue()));
        if (optionalStudentLessonKey.isPresent()) {
            throw exceptionHandler.studentAlreadyLogin(keyValue, studentId);
        }
    }
}
