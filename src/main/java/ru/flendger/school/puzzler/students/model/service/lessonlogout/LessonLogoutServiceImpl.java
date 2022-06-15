package ru.flendger.school.puzzler.students.model.service.lessonlogout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.settings.StudentLessonKeyBeforeTimeSetting;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;
import ru.flendger.school.puzzler.students.model.entity.StudentLesson;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonLogoutServiceImpl implements LessonLogoutService {
    private final StudentLessonKeyStorageService studentLessonKeyStorageService;
    private final ApplicationSettingsService applicationSettingsService;
    private final DateTimeService dateTimeService;
    private final StudentLessonStorageService studentLessonStorageService;

    @Override
    @Transactional
    public void logout(Long studentId, String lessonKey) {
        LocalDateTime loginDate = dateTimeService.current();
        StudentLessonKeyBeforeTimeSetting lessonKeyBeforeTimeSetting = applicationSettingsService.getSetting(StudentLessonKeyBeforeTimeSetting.class);

        Optional<StudentLessonKey> optionalStudentLessonKey = studentLessonKeyStorageService.findActiveLoginKey(lessonKey, studentId, loginDate.minusHours(lessonKeyBeforeTimeSetting.getValue()));
        if (optionalStudentLessonKey.isEmpty()) {
            return;
        }

        StudentLessonKey studentLessonKey = optionalStudentLessonKey.get();
        studentLessonKeyStorageService.delete(studentLessonKey);

        Optional<StudentLesson> optionalStudentLesson = studentLessonStorageService.findById(studentLessonKey.getStudentLessonId());
        optionalStudentLesson.ifPresent(studentLessonStorageService::delete);
    }
}
