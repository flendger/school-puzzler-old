package ru.flendger.school.puzzler.model.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.dto.StudentDto;
import ru.flendger.school.puzzler.model.service.output.StudentStorageService;
import ru.flendger.school.puzzler.model.entity.LessonKey;
import ru.flendger.school.puzzler.model.service.output.LessonKeyStorageService;

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
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public List<StudentDto> findStudentsByLessonKey(String keyValue) {
        Optional<LessonKey> optionalLessonKey = lessonKeyStorageService.findActive(keyValue, dateTimeService.current());
        if (optionalLessonKey.isEmpty()) {
            return Collections.emptyList();
        }

        LessonKey lessonKey = optionalLessonKey.get();
        return studentStorageService
                .findBySchoolClass(lessonKey.getSchoolClassId())
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }
}
