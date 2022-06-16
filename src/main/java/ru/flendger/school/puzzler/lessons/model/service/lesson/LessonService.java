package ru.flendger.school.puzzler.lessons.model.service.lesson;

import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonDto;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonRowDto;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    List<LessonRowDto> findBySubject(Long subjectId);

    List<LessonRowDto> findAll();

    Optional<LessonRowDto> findRowById(Long id);

    Optional<LessonDto> findById(Long id);
}
