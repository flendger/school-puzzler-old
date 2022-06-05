package ru.flendger.school.puzzler.model.service.output;

import ru.flendger.school.puzzler.model.service.output.CrudStorageService;
import ru.flendger.school.puzzler.model.entity.LessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LessonKeyStorageService extends CrudStorageService<LessonKey, Long> {
    Optional<LessonKey> findActive(String keyValue, LocalDateTime expiredDate);

    void deleteExpired(LocalDateTime expiredDate);
}
