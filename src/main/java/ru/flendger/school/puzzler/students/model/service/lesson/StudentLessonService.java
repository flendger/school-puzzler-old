package ru.flendger.school.puzzler.students.model.service.lesson;

import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;

public interface StudentLessonService {
    StudentLessonDto getLesson(Long id);
}
