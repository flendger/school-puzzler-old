package ru.flendger.school.puzzler.students.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LessonKeyStorageService extends CrudStorageService<LessonKey, Long> {
    Optional<LessonKey> findActive(String keyValue, LocalDateTime expiredDate);

    void deleteExpired(LocalDateTime expiredDate);
}
