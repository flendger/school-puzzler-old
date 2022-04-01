package ru.flendger.school.puzzler.model.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;
import ru.flendger.school.puzzler.model.service.output.LessonStorageService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentLessonServiceImpl implements StudentLessonService {
    private final ModelMapper modelMapper;
    private final LessonStorageService lessonStorageService;

    @Override
    public List<LessonRowDto> getLessons() {
        return lessonStorageService.findAll()
                .stream()
                .map(lesson -> modelMapper.map(lesson, LessonRowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LessonDto> getLesson(Long id) {
        return lessonStorageService.findById(id)
                .map(lesson -> modelMapper.map(lesson, LessonDto.class));
    }
}
