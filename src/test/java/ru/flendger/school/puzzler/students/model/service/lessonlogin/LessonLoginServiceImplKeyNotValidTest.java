package ru.flendger.school.puzzler.students.model.service.lessonlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.flendger.school.puzzler.students.database.repository.LessonKeyRepository;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginRequest;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.KeyNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("off-liquibase")
class LessonLoginServiceImplKeyNotValidTest {
    @Autowired
    private LessonLoginServiceImpl lessonLoginService;

    @Autowired
    private LessonKeyRepository lessonKeyRepository;

    List<LessonKey> lessonKeys = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lessonKeys.add(createAndSaveLessonKey(LocalDateTime.of(1900, 1, 1, 0, 0)));
    }

    private LessonKey createAndSaveLessonKey(LocalDateTime expiredDate) {
        LessonKey lessonKey = LessonKey
                .builder()
                .keyValue("000002")
                .lessonId(1L)
                .schoolClassId(1L)
                .expiredDate(expiredDate)
                .build();

        return lessonKeyRepository.save(lessonKey);
    }

    @AfterEach
    void tearDown() {
        lessonKeyRepository.deleteAll(lessonKeys);
    }

    @Test
    void lessonKeyNotValid() {
        LessonLoginRequest loginRequest1 = createLessonLoginRequest("000001");
        assertThrows(KeyNotFoundException.class, () -> lessonLoginService.login(loginRequest1));

        LessonLoginRequest loginRequest2 = createLessonLoginRequest("000002");
        assertThrows(KeyNotFoundException.class, () -> lessonLoginService.login(loginRequest2));
    }

    private LessonLoginRequest createLessonLoginRequest(String keyValue) {
        LessonLoginRequest loginRequest = new LessonLoginRequest();

        loginRequest.setKeyValue(keyValue);
        loginRequest.setStudentId(1111L);

        return loginRequest;
    }
}