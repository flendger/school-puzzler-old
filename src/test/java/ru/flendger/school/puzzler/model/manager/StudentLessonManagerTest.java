package ru.flendger.school.puzzler.model.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.flendger.school.puzzler.model.config.ModelMapperConfig;
import ru.flendger.school.puzzler.model.config.factory.ModelMapperFactory;
import ru.flendger.school.puzzler.model.config.converter.LessonToLessonDtoPostConverter;
import ru.flendger.school.puzzler.model.dto.*;
import ru.flendger.school.puzzler.model.entity.*;
import ru.flendger.school.puzzler.model.enums.TaskValueType;
import ru.flendger.school.puzzler.model.service.input.StudentLessonService;
import ru.flendger.school.puzzler.model.service.input.StudentLessonServiceImpl;
import ru.flendger.school.puzzler.model.service.output.LessonStorageService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        ModelMapperConfig.class,
        ModelMapperFactory.class,
        LessonToLessonDtoPostConverter.class,
        StudentLessonServiceImpl.class})
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
        taskValue.setAccesable(true);
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
        List<LessonRowDto> lessons = studentLessonService.getLessons();

        assertFalse(lessons.isEmpty());

        LessonRowDto lessonRowDto = lessons.get(0);
        assertEquals(1L, lessonRowDto.getId());
        assertEquals(LESSON_NAME, lessonRowDto.getName());
        assertEquals(LESSON_TITLE, lessonRowDto.getTitle());
        assertEquals(SUBJECT_NAME, lessonRowDto.getSubjectName());
    }

    @Test
    void testGetSingleLesson() {
        Optional<LessonDto> lesson = studentLessonService.getLesson(1L);

        assertFalse(lesson.isEmpty());

        LessonDto lessonDto = lesson.get();
        assertEquals(1L, lessonDto.getId());
        assertEquals(LESSON_NAME, lessonDto.getName());
        assertEquals(LESSON_TITLE, lessonDto.getTitle());

        List<HeaderDto> taskStructureTaskColumns = lessonDto.getHeaders();
        assertNotNull(taskStructureTaskColumns);
        assertEquals(3, taskStructureTaskColumns.size());

        HeaderDto headerDto1 = taskStructureTaskColumns.get(0);
        assertEquals(4L, headerDto1.getId());
        assertEquals("column_0", headerDto1.getName());
        assertEquals(0, headerDto1.getOrder());

        HeaderDto headerDto2 = taskStructureTaskColumns.get(1);
        assertEquals(5L, headerDto2.getId());
        assertEquals("column_1", headerDto2.getName());
        assertEquals(1, headerDto2.getOrder());

        List<TaskRowDto> tasks = lessonDto.getTasks();
        assertEquals(1, tasks.size());

        TaskRowDto taskRowDto = tasks.get(0);
        assertEquals(6L, taskRowDto.getId());
        assertEquals(TASK_NAME, taskRowDto.getName());
        assertEquals(TASK_TITLE, taskRowDto.getTitle());

        List<TaskValueDto> values = taskRowDto.getValues();
        assertEquals(2, values.size());

        TaskValueDto taskValueDto1 = values.get(0);
        assertEquals(7L, taskValueDto1.getId());
        assertEquals(1, taskValueDto1.getColumnOrder());
        assertEquals(VALUE_1, taskValueDto1.getValue1());
        assertEquals(VALUE_2, taskValueDto1.getValue2());
        assertEquals(VALUE_3, taskValueDto1.getValue3());
        assertEquals("NUMBER", taskValueDto1.getValueType());

        TaskValueDto taskValueDto2 = values.get(1);
        assertEquals(9L, taskValueDto2.getId());
        assertEquals(2, taskValueDto2.getColumnOrder());
        assertEquals(VALUE_1, taskValueDto2.getValue1());
        assertEquals(VALUE_2, taskValueDto2.getValue2());
        assertEquals(VALUE_3, taskValueDto2.getValue3());
        assertEquals("NUMBER", taskValueDto2.getValueType());
    }
}