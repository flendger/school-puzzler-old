package ru.flendger.school.puzzler.students.model.service.lesson;

import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonRowDto;

import java.util.List;
import java.util.Optional;

public interface StudentLessonService {
    List<StudentLessonRowDto> getLessons();

    Optional<StudentLessonDto> getLesson(Long id);
}
