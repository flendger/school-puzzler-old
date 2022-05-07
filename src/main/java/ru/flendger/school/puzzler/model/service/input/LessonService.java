package ru.flendger.school.puzzler.model.service.input;

import ru.flendger.school.puzzler.model.dto.LessonRowDto;

import java.util.List;

public interface LessonService {
    List<LessonRowDto> find(Long subjectId);
}
