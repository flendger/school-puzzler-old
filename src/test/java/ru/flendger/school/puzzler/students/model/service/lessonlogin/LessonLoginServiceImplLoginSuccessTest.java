package ru.flendger.school.puzzler.students.model.service.lessonlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.flendger.school.puzzler.students.database.repository.*;
import ru.flendger.school.puzzler.students.model.entity.*;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("off-liquibase")
class LessonLoginServiceImplLoginSuccessTest {
    private static final String LESSON_KEY = "000004";
    private static final Long LESSON_ID = 1L;
    @Autowired
    private LessonLoginServiceImpl lessonLoginService;

    @Autowired
    private LessonKeyRepository lessonKeyRepository;

    @Autowired
    private StudentLessonKeyRepository studentLessonKeyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private StudentLessonRepository studentLessonRepository;

    private final List<LessonKey> lessonKeys = new ArrayList<>();
    private final List<StudentLessonKey> studentLessonKeys = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<SchoolClass> schoolClasses = new ArrayList<>();
    private StudentLesson studentLesson;

    private Long studentId;

    @BeforeEach
    void setUp() {
        lessonKeys.add(createAndSaveLessonKey(LocalDateTime.now().plusMinutes(60L)));

        SchoolClass schoolClass = createAndSaveSchoolClass();
        schoolClasses.add(schoolClass);

        Student student = createAndSaveStudent(schoolClass);
        students.add(student);

        studentLessonKeys.add(createAndSaveStudentLessonKey(student));

        studentId = student.getId();
    }

    private SchoolClass createAndSaveSchoolClass() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName("class_test");

        return schoolClassRepository.save(schoolClass);
    }

    private Student createAndSaveStudent(SchoolClass schoolClass) {
        Student student = new Student();
        student.setName("student_test");
        student.setSchoolClass(schoolClass);

        return studentRepository.save(student);
    }

    private StudentLessonKey createAndSaveStudentLessonKey(Student student) {
        StudentLessonKey studentLessonKey = StudentLessonKey
                .builder()
                .keyValue(LESSON_KEY)
                .studentId(student.getId())
                .loginDate(LocalDateTime.now().minusDays(1L))
                .build();

        return studentLessonKeyRepository.save(studentLessonKey);
    }

    private LessonKey createAndSaveLessonKey(LocalDateTime expiredDate) {
        LessonKey lessonKey = LessonKey
                .builder()
                .keyValue(LESSON_KEY)
                .lessonId(LESSON_ID)
                .schoolClassId(1L)
                .expiredDate(expiredDate)
                .build();

        return lessonKeyRepository.save(lessonKey);
    }

    @AfterEach
    void tearDown() {
        if (Objects.nonNull(studentLesson)) {
            studentLessonRepository.delete(studentLesson);
        }
        lessonKeyRepository.deleteAll(lessonKeys);
        studentLessonKeyRepository.deleteAll(studentLessonKeys);
        studentRepository.deleteAll(students);
        schoolClassRepository.deleteAll(schoolClasses);
    }

    @Test
    void studentLoginSuccess() {
        LessonLoginRequest loginRequest = createLessonLoginRequest();
        assertDoesNotThrow(() -> lessonLoginService.login(loginRequest));

        Optional<StudentLessonKey> optionalStudentLessonKey = studentLessonKeyRepository.findFirstByKeyValueAndStudentIdAndLoginDateIsGreaterThanEqualOrderByLoginDateDesc(loginRequest.getKeyValue(),
                loginRequest.getStudentId(),
                LocalDateTime.now().minusHours(1L));
        optionalStudentLessonKey.ifPresent(studentLessonKeys::add);

        Optional<StudentLesson> optionalStudentLesson = studentLessonRepository.findFirstByStudent_IdAndLessonIdOrderByStartedAtDesc(loginRequest.getStudentId(), LESSON_ID);
        optionalStudentLesson.ifPresent(lesson -> studentLesson = lesson);

        assertTrue(optionalStudentLessonKey.isPresent());
        assertTrue(optionalStudentLesson.isPresent());
    }

    private LessonLoginRequest createLessonLoginRequest() {
        LessonLoginRequest loginRequest = new LessonLoginRequest();

        loginRequest.setKeyValue(LESSON_KEY);
        loginRequest.setStudentId(studentId);

        return loginRequest;
    }
}