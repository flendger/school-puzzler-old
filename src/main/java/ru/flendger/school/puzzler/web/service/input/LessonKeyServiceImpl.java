package ru.flendger.school.puzzler.web.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.service.input.DateTimeService;
import ru.flendger.school.puzzler.model.service.output.LessonStorageService;
import ru.flendger.school.puzzler.model.service.output.SchoolClassStorageService;
import ru.flendger.school.puzzler.model.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.model.settings.props.KeyExpiredTimeSetting;
import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.LessonKeyResponse;
import ru.flendger.school.puzzler.web.entity.LessonKey;
import ru.flendger.school.puzzler.web.generator.KeyGenerator;
import ru.flendger.school.puzzler.web.service.output.LessonKeyStorageService;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonKeyServiceImpl implements LessonKeyService {
    private final KeyGenerator keyGenerator;
    private final DateTimeService dateTimeService;
    private final LessonKeyStorageService lessonKeyStorageService;
    private final ModelMapper modelMapper;
    private final ApplicationSettingsService applicationSettingsService;
    private final LessonStorageService lessonStorageService;
    private final SchoolClassStorageService schoolClassStorageService;

    @Override
    @Transactional
    public LessonKeyResponse generateKey(LessonKeyRequest lessonKeyRequest) {
        KeyExpiredTimeSetting keyExpiredTimeSetting = applicationSettingsService.getSetting(KeyExpiredTimeSetting.class);

        Long lessonId = lessonKeyRequest.getLessonId();
        Lesson lesson = lessonStorageService
                .findById(lessonId)
                .orElseThrow(() -> createLessonNotFoundException(lessonId));

        Long schoolClassId = lessonKeyRequest.getSchoolClassId();
        SchoolClass schoolClass = schoolClassStorageService
                .findById(schoolClassId)
                .orElseThrow(() -> createSchoolClassNotFoundException(schoolClassId));

        LocalDateTime expiredDate = dateTimeService.current().plusSeconds(keyExpiredTimeSetting.getValue());

        LessonKeyResponse lessonKeyResponse =
                LessonKeyResponse
                        .builder()
                        .keyValue(keyGenerator.generate())
                        .lessonId(lessonId)
                        .lessonName(lesson.getName())
                        .schoolClassId(schoolClassId)
                        .schoolClassName(schoolClass.getName())
                        .expiredDate(expiredDate)
                        .expiredDateString(dateTimeService.toLocalFormat(expiredDate))
                        .build();

        LessonKey lessonKey = modelMapper.map(lessonKeyResponse, LessonKey.class);
        lessonKeyStorageService.save(lessonKey);

        return lessonKeyResponse;
    }

    private EntityNotFoundException createSchoolClassNotFoundException(Long schoolClassId) {
        return new EntityNotFoundException(messageSchoolClassNotFound(schoolClassId));
    }

    private String messageSchoolClassNotFound(Long schoolClassId) {
        return String.format("School class %d not found", schoolClassId);
    }

    private EntityNotFoundException createLessonNotFoundException(Long lessonId) {
        return new EntityNotFoundException(messageLessonNotFound(lessonId));
    }

    private String messageLessonNotFound(Long lessonId) {
        return String.format("Lesson %d not found", lessonId);
    }

    @Override
    public void delete(String key) throws EntityNotFoundException {
        Optional<LessonKey> keyOptional = lessonKeyStorageService.findActive(key, dateTimeService.current());
        if (keyOptional.isEmpty()) {
            throw createActiveKeyNotFoundException(key);
        }

        lessonKeyStorageService.delete(keyOptional.get());
    }

    private EntityNotFoundException createActiveKeyNotFoundException(String key) {
        return new EntityNotFoundException(messageActiveKeyNotFound(key));
    }

    private String messageActiveKeyNotFound(String key) {
        return String.format("Active lesson key %s doesn't exist", key);
    }
}
