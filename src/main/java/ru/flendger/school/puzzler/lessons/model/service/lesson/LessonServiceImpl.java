package ru.flendger.school.puzzler.lessons.model.service.lesson;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonDto;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonRowDto;
import ru.flendger.school.puzzler.lessons.model.dao.LessonStorageService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonStorageService lessonStorageService;
    private final ModelMapper lessonsModelMapper;

    @Override
    public List<LessonRowDto> findBySubject(Long subjectId) {
        return lessonStorageService
                .findBySubject(subjectId)
                .stream()
                .map(lesson -> lessonsModelMapper.map(lesson, LessonRowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LessonRowDto> findAll() {
        return lessonStorageService
                .findAll()
                .stream()
                .map(lesson -> lessonsModelMapper.map(lesson, LessonRowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LessonDto> findById(Long id) {
        return lessonStorageService
                .findById(id)
                .map(lesson -> lessonsModelMapper.map(lesson, LessonDto.class));
    }
}
