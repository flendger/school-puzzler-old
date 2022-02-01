package ru.flendger.school.puzzler.model.manager;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;
import ru.flendger.school.puzzler.model.service.LessonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentLessonManagerImpl implements StudentLessonManager {
    private final ModelMapper modelMapper;
    private final LessonService lessonService;

    @Override
    public List<LessonRowDto> getLessons() {
        return lessonService.findAll()
                .stream()
                .map(lesson -> modelMapper.map(lesson, LessonRowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LessonDto> getLesson(Long id) {
        return lessonService.findById(id)
                .map(lesson -> modelMapper.map(lesson, LessonDto.class));
    }
}
