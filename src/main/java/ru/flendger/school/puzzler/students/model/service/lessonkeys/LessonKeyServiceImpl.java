package ru.flendger.school.puzzler.students.model.service.lessonkeys;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.lessons.model.entity.lesson.Lesson;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.students.model.entity.SchoolClass;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.lessons.model.dao.LessonStorageService;
import ru.flendger.school.puzzler.students.model.dao.SchoolClassStorageService;
import ru.flendger.school.puzzler.settings.KeyExpiredTimeSetting;
import ru.flendger.school.puzzler.students.model.service.lessonkeys.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.students.model.service.lessonkeys.dto.LessonKeyResponse;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.service.lessonkeys.generator.KeyGenerator;
import ru.flendger.school.puzzler.students.model.dao.LessonKeyStorageService;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonKeyServiceImpl implements LessonKeyService {
    private final KeyGenerator keyGenerator;
    private final DateTimeService dateTimeService;
    private final LessonKeyStorageService lessonKeyStorageService;
    private final ModelMapper studentsModelMapper;
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

        LessonKey lessonKey = studentsModelMapper.map(lessonKeyResponse, LessonKey.class);
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
