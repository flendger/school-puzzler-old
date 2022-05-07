package ru.flendger.school.puzzler.model.service.output;

import ru.flendger.school.puzzler.model.entity.Lesson;

import java.util.List;

public interface LessonStorageService extends CrudStorageService<Lesson, Long> {
    List<Lesson> findBySubject(Long subjectId);
}
