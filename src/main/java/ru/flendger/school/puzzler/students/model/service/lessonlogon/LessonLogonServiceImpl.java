package ru.flendger.school.puzzler.students.model.service.lessonlogon;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.students.model.dao.LessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentStorageService;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.service.lessonlogon.dto.LessonLogonStudentDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonLogonServiceImpl implements LessonLogonService {
    private final LessonKeyStorageService lessonKeyStorageService;
    private final DateTimeService dateTimeService;
    private final StudentStorageService studentStorageService;
    private final ModelMapper studentsModelMapper;

    @Override
    @Transactional
    public List<LessonLogonStudentDto> findStudentsByLessonKey(String keyValue) {
        Optional<LessonKey> optionalLessonKey = lessonKeyStorageService.findActive(keyValue, dateTimeService.current());
        if (optionalLessonKey.isEmpty()) {
            return Collections.emptyList();
        }

        LessonKey lessonKey = optionalLessonKey.get();
        return studentStorageService
                .findBySchoolClass(lessonKey.getSchoolClassId())
                .stream()
                .map(student -> studentsModelMapper.map(student, LessonLogonStudentDto.class))
                .collect(Collectors.toList());
    }
}
