package ru.flendger.school.puzzler.web.service.input;

import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.LessonKeyResponse;

public interface LessonKeyService {
    LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest);
    void delete(String key);
}
