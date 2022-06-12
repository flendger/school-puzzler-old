package ru.flendger.school.puzzler.students.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StudentLessonKeyStorageService extends CrudStorageService<StudentLessonKey, Long> {
    Optional<StudentLessonKey> findActiveLoginKey(String keyValue, Long studentId, LocalDateTime loginDate);
}
