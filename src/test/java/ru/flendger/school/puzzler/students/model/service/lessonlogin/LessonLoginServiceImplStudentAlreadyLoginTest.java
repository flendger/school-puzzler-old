package ru.flendger.school.puzzler.students.model.service.lessonlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.flendger.school.puzzler.students.database.repository.LessonKeyRepository;
import ru.flendger.school.puzzler.students.database.repository.SchoolClassRepository;
import ru.flendger.school.puzzler.students.database.repository.StudentLessonKeyRepository;
import ru.flendger.school.puzzler.students.database.repository.StudentRepository;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.entity.SchoolClass;
import ru.flendger.school.puzzler.students.model.entity.Student;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginRequest;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.StudentAlreadyLoginException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("off-liquibase")
class LessonLoginServiceImplStudentAlreadyLoginTest {
    private static final String LESSON_KEY = "000003";
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

    private final List<LessonKey> lessonKeys = new ArrayList<>();
    private final List<StudentLessonKey> studentLessonKeys = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<SchoolClass> schoolClasses = new ArrayList<>();

    Long studentId;

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
                .studentLessonId(1L)
                .loginDate(LocalDateTime.now())
                .build();

        return studentLessonKeyRepository.save(studentLessonKey);
    }

    private LessonKey createAndSaveLessonKey(LocalDateTime expiredDate) {
        LessonKey lessonKey = LessonKey
                .builder()
                .keyValue(LESSON_KEY)
                .lessonId(1L)
                .schoolClassId(1L)
                .expiredDate(expiredDate)
                .build();

        return lessonKeyRepository.save(lessonKey);
    }

    @AfterEach
    void tearDown() {
        lessonKeyRepository.deleteAll(lessonKeys);
        studentLessonKeyRepository.deleteAll(studentLessonKeys);
        studentRepository.deleteAll(students);
        schoolClassRepository.deleteAll(schoolClasses);
    }

    @Test
    void studentAlreadyLogin() {
        LessonLoginRequest loginRequest1 = createLessonLoginRequest();
        assertThrows(StudentAlreadyLoginException.class, () -> lessonLoginService.login(loginRequest1));
    }

    private LessonLoginRequest createLessonLoginRequest() {
        LessonLoginRequest loginRequest = new LessonLoginRequest();

        loginRequest.setKeyValue(LESSON_KEY);
        loginRequest.setStudentId(studentId);

        return loginRequest;
    }
}