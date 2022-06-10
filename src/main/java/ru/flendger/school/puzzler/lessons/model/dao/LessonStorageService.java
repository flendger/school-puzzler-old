package ru.flendger.school.puzzler.lessons.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.lessons.model.entity.Lesson;

import java.util.List;

public interface LessonStorageService extends CrudStorageService<Lesson, Long> {
    List<Lesson> findBySubject(Long subjectId);
}
