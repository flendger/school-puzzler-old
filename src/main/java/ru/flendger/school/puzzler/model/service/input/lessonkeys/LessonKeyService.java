package ru.flendger.school.puzzler.model.service.input.lessonkeys;

import ru.flendger.school.puzzler.model.entity.LessonKeyRequest;
import ru.flendger.school.puzzler.model.entity.LessonKeyResponse;

public interface LessonKeyService {
    LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest);
    void delete(String key);
}
