package ru.flendger.school.puzzler.web.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.service.input.DateTimeService;
import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.LessonKeyResponse;
import ru.flendger.school.puzzler.web.entity.LessonKey;
import ru.flendger.school.puzzler.web.generator.KeyGenerator;
import ru.flendger.school.puzzler.web.service.output.LessonKeyStorageService;

@Service
@RequiredArgsConstructor
public class LessonKeyServiceImpl implements LessonKeyService {
    private final KeyGenerator keyGenerator;
    private final DateTimeService dateTimeService;
    private final LessonKeyStorageService lessonKeyStorageService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest) {
        LessonKeyResponse lessonKeyResponse = new LessonKeyResponse(
                keyGenerator.generate(),
                lessonKeyRequest.getLessonId(),
                lessonKeyRequest.getSchoolClassId(),
                dateTimeService.current().plusSeconds(45 * 60)); // TODO: 05.04.2022 to app properties

        LessonKey lessonKey = modelMapper.map(lessonKeyResponse, LessonKey.class);
        lessonKeyStorageService.save(lessonKey);

        return lessonKeyResponse;
    }
}
