package ru.flendger.school.puzzler.model.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;
import ru.flendger.school.puzzler.model.service.output.LessonStorageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonStorageService lessonStorageService;
    private final ModelMapper modelMapper;

    @Override
    public List<LessonRowDto> find(Long subjectId) {
        return lessonStorageService
                .findBySubject(subjectId)
                .stream()
                .map(lesson -> modelMapper.map(lesson, LessonRowDto.class))
                .collect(Collectors.toList());
    }
}
