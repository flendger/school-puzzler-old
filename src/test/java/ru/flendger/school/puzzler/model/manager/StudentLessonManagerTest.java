package ru.flendger.school.puzzler.model.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.flendger.school.puzzler.lessons.model.dao.LessonStorageService;
import ru.flendger.school.puzzler.lessons.model.entity.*;
import ru.flendger.school.puzzler.lessons.model.enums.TaskValueType;
import ru.flendger.school.puzzler.lessons.model.service.lesson.LessonServiceImpl;
import ru.flendger.school.puzzler.students.model.config.StudentsModelMapperConfig;
import ru.flendger.school.puzzler.students.model.config.factory.converter.LessonDtoToStudentLessonDtoPostConverter;
import ru.flendger.school.puzzler.students.model.config.factory.ModelMapperFactory;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonHeaderDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonTaskRowDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonTaskValueDto;
import ru.flendger.school.puzzler.students.model.service.lesson.StudentLessonService;
import ru.flendger.school.puzzler.students.model.service.lesson.StudentLessonServiceImpl;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonRowDto;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        StudentsModelMapperConfig.class,
        ModelMapperFactory.class,
        LessonDtoToStudentLessonDtoPostConverter.class,
        LessonStorageService.class,
        LessonServiceImpl.class,
        StudentLessonServiceImpl.class})
@ActiveProfiles("off-liquibase")
class StudentLessonManagerTest {
    private final static String LESSON_NAME = "lesson_name";
    private final static String LESSON_TITLE = "lesson_title";
    private final static String SUBJECT_NAME = "subject_name";
    private static final String TASK_NAME = "task_name";
    private static final String TASK_TITLE = "task_title";
    private static final String VALUE_1 = "value_1";
    private static final String VALUE_2 = "value_2";
    private static final String VALUE_3 = "value_3";
    private static final String COLUMN_PREFIX = "column_";

    @Autowired
    private StudentLessonService studentLessonService;

    @MockBean
    private LessonStorageService lessonStorageService;

    @BeforeEach
    public void init() {
        Mockito
                .when(lessonStorageService.findAll())
                .thenReturn(getDefaultLessons());

        Mockito
                .when(lessonStorageService.findById(1L))
                .thenReturn(getSingleLesson());
    }

    private List<Lesson> getDefaultLessons() {
        Lesson lesson = createLesson();

        return List.of(lesson);
    }

    private Optional<Lesson> getSingleLesson() {
        return Optional.of(createLesson());
    }

    private Lesson createLesson() {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setName(LESSON_NAME);
        lesson.setTitle(LESSON_TITLE);

        lesson.setSubject(createSubject());

        TaskStructure taskStructure = createTaskStructure();
        lesson.setTaskStructure(taskStructure);

        TaskColumn taskColumn1 = createTaskColumn(4L, 0);
        TaskColumn taskColumn2 = createTaskColumn(5L, 1);
        TaskColumn taskColumn3 = createTaskColumn(8L, 2);
        taskStructure.setTaskColumns(List.of(taskColumn1, taskColumn2, taskColumn3));

        Task task = createTask();
        task.setTaskStructure(taskStructure);
        task.setTaskColumn(taskColumn1);
        lesson.setTasks(List.of(task));

        TaskValue taskValue1 = createTaskValue(7L);
        taskValue1.setTaskColumn(taskColumn2);
        TaskValue taskValue2 = createTaskValue(9L);
        taskValue2.setTaskColumn(taskColumn3);
        task.setTaskValues(List.of(taskValue2, taskValue1)); //inverse order

        return lesson;
    }

    private TaskValue createTaskValue(Long taskValueId) {
        TaskValue taskValue = new TaskValue();
        taskValue.setId(taskValueId);
        taskValue.setValue1(VALUE_1);
        taskValue.setValue2(VALUE_2);
        taskValue.setValue3(VALUE_3);
        taskValue.setAccessible(true);
        taskValue.setValueType(TaskValueType.NUMBER);

        return taskValue;
    }

    private Task createTask() {
        Task task = new Task();
        task.setId(6L);
        task.setName(TASK_NAME);
        task.setTitle(TASK_TITLE);

        return task;
    }

    private TaskColumn createTaskColumn(long columnId, int order) {
        TaskColumn taskColumn = new TaskColumn();
        taskColumn.setId(columnId);
        taskColumn.setOrder(order);
        taskColumn.setName(COLUMN_PREFIX + order);

        return taskColumn;
    }

    private TaskStructure createTaskStructure() {
        TaskStructure taskStructure = new TaskStructure();
        taskStructure.setId(3L);
        taskStructure.setName("structure_name");

        return taskStructure;
    }

    private Subject createSubject() {
        Subject subject = new Subject();
        subject.setId(2L);
        subject.setName(SUBJECT_NAME);

        return subject;
    }

    @Test
    void testGetLessons() {
        List<StudentLessonRowDto> lessons = studentLessonService.getLessons();

        assertFalse(lessons.isEmpty());

        StudentLessonRowDto lessonRowDto = lessons.get(0);
        assertEquals(1L, lessonRowDto.getId());
        assertEquals(LESSON_NAME, lessonRowDto.getName());
        assertEquals(LESSON_TITLE, lessonRowDto.getTitle());
        assertEquals(SUBJECT_NAME, lessonRowDto.getSubjectName());
    }

    @Test
    void testGetSingleLesson() {
        Optional<StudentLessonDto> lesson = studentLessonService.getLesson(1L);

        assertFalse(lesson.isEmpty());

        StudentLessonDto studentLessonDto = lesson.get();
        assertEquals(1L, studentLessonDto.getId());
        assertEquals(LESSON_NAME, studentLessonDto.getName());
        assertEquals(LESSON_TITLE, studentLessonDto.getTitle());

        List<StudentLessonHeaderDto> taskStructureTaskColumns = studentLessonDto.getHeaders();
        assertNotNull(taskStructureTaskColumns);
        assertEquals(3, taskStructureTaskColumns.size());

        StudentLessonHeaderDto studentLessonHeaderDto1 = taskStructureTaskColumns.get(0);
        assertEquals(4L, studentLessonHeaderDto1.getId());
        assertEquals("column_0", studentLessonHeaderDto1.getName());
        assertEquals(0, studentLessonHeaderDto1.getOrder());

        StudentLessonHeaderDto studentLessonHeaderDto2 = taskStructureTaskColumns.get(1);
        assertEquals(5L, studentLessonHeaderDto2.getId());
        assertEquals("column_1", studentLessonHeaderDto2.getName());
        assertEquals(1, studentLessonHeaderDto2.getOrder());

        List<StudentLessonTaskRowDto> tasks = studentLessonDto.getTasks();
        assertEquals(1, tasks.size());

        StudentLessonTaskRowDto studentLessonTaskRowDto = tasks.get(0);
        assertEquals(6L, studentLessonTaskRowDto.getId());
        assertEquals(TASK_NAME, studentLessonTaskRowDto.getName());
        assertEquals(TASK_TITLE, studentLessonTaskRowDto.getTitle());

        List<StudentLessonTaskValueDto> values = studentLessonTaskRowDto.getValues();
        assertEquals(2, values.size());

        StudentLessonTaskValueDto studentLessonTaskValueDto1 = values.get(0);
        assertEquals(7L, studentLessonTaskValueDto1.getId());
        assertEquals(1, studentLessonTaskValueDto1.getColumnOrder());
        assertEquals(VALUE_1, studentLessonTaskValueDto1.getValue1());
        assertEquals(VALUE_2, studentLessonTaskValueDto1.getValue2());
        assertEquals(VALUE_3, studentLessonTaskValueDto1.getValue3());
        assertEquals("NUMBER", studentLessonTaskValueDto1.getValueType());

        StudentLessonTaskValueDto studentLessonTaskValueDto2 = values.get(1);
        assertEquals(9L, studentLessonTaskValueDto2.getId());
        assertEquals(2, studentLessonTaskValueDto2.getColumnOrder());
        assertEquals(VALUE_1, studentLessonTaskValueDto2.getValue1());
        assertEquals(VALUE_2, studentLessonTaskValueDto2.getValue2());
        assertEquals(VALUE_3, studentLessonTaskValueDto2.getValue3());
        assertEquals("NUMBER", studentLessonTaskValueDto2.getValueType());
    }
}