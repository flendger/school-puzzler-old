package ru.flendger.school.puzzler.students.model.service.lessonlogout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.settings.StudentLessonKeyBeforeTimeSetting;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LessonLogoutServiceImpl implements LessonLogoutService {
    private final StudentLessonKeyStorageService studentLessonKeyStorageService;
    private final ApplicationSettingsService applicationSettingsService;
    private final DateTimeService dateTimeService;
    private final StudentLessonStorageService studentLessonStorageService;

    @Override
    @Transactional
    public void logout(Long studentId, String lessonKey) {
        LocalDateTime loginDate = dateTimeService.current();
        StudentLessonKeyBeforeTimeSetting lessonKeyBeforeTimeSetting = applicationSettingsService.getSetting(StudentLessonKeyBeforeTimeSetting.class);

        studentLessonKeyStorageService
                .findActiveLoginKey(lessonKey, studentId, loginDate.minusHours(lessonKeyBeforeTimeSetting.getValue()))
                .ifPresent(studentLessonKey -> {
                    studentLessonKeyStorageService.delete(studentLessonKey);

                    studentLessonStorageService
                            .findById(studentLessonKey.getStudentLessonId())
                            .ifPresent(studentLessonStorageService::delete);
                });
    }
}
