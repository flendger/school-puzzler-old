package ru.flendger.school.puzzler.model.manager;

import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;

import java.util.List;

public interface StudentLessonManager {
    List<LessonRowDto> getLessons();
    LessonDto getLesson(Long id);
}
