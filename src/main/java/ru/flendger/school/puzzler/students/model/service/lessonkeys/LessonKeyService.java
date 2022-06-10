package ru.flendger.school.puzzler.students.model.service.lessonkeys;

import ru.flendger.school.puzzler.students.model.service.lessonkeys.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.students.model.service.lessonkeys.dto.LessonKeyResponse;

public interface LessonKeyService {
    LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest);
    void delete(String key);
}
