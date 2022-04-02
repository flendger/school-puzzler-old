package ru.flendger.school.puzzler.web.service.output;

import ru.flendger.school.puzzler.model.service.output.CrudStorageService;
import ru.flendger.school.puzzler.web.entity.LessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LessonKeyStorageService extends CrudStorageService<LessonKey, Long> {
    Optional<LessonKey> findActive(String keyValue, LocalDateTime expiredDate);

    void deleteExpired(LocalDateTime expiredDate);
}
