package ru.flendger.school.puzzler.model.service.input;

import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;

import java.util.List;
import java.util.Optional;

public interface StudentLessonService {
    List<LessonRowDto> getLessons();

    Optional<LessonDto> getLesson(Long id);
}
