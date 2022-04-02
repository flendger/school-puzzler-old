package ru.flendger.school.puzzler.web.service.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.service.input.DateTimeService;
import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.LessonKeyResponse;
import ru.flendger.school.puzzler.web.generator.KeyGenerator;

@Service
@RequiredArgsConstructor
public class LessonKeyServiceImpl implements LessonKeyService {
    private final KeyGenerator keyGenerator;
    private final DateTimeService dateTimeService;

    @Override
    public LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest) {
        return new LessonKeyResponse(
                keyGenerator.generate(),
                lessonKeyRequest.getLessonId(),
                lessonKeyRequest.getSchoolClassId(),
                dateTimeService.current());
    }
}
