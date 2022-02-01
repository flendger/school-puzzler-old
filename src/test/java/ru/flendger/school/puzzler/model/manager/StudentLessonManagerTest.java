package ru.flendger.school.puzzler.model.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.entity.Subject;
import ru.flendger.school.puzzler.model.service.LessonService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {
        ModelMapper.class,
        StudentLessonManagerImpl.class})
class StudentLessonManagerTest {
    @Autowired
    private StudentLessonManager studentLessonManager;

    @MockBean
    private LessonService lessonService;

    @BeforeEach
    public void init() {
        Mockito
                .when(lessonService.findAll())
                .thenReturn(getDefaultLessons());

        Mockito
                .when(lessonService.findById(1L))
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
        lesson.setName("lesson name");
        lesson.setTitle("lesson title");

        Subject subject = new Subject();
        subject.setName("subject name");
        lesson.setSubject(subject);

        return lesson;
    }

    @Test
    void testGetLessons() {
        List<LessonRowDto> lessons = studentLessonManager.getLessons();

        assertFalse(lessons.isEmpty());

        LessonRowDto lessonRowDto = lessons.get(0);
        assertEquals(1L, lessonRowDto.getId());
        assertEquals("lesson name", lessonRowDto.getName());
        assertEquals("lesson title", lessonRowDto.getTitle());
        assertEquals("subject name", lessonRowDto.getSubjectName());
    }

    @Test
    void testGetSingleLesson() {
        Optional<LessonDto> lesson = studentLessonManager.getLesson(1L);

        assertFalse(lesson.isEmpty());

        LessonDto lessonDto = lesson.get();
        assertEquals(1L, lessonDto.getId());
        assertEquals("lesson name", lessonDto.getName());
        assertEquals("lesson title", lessonDto.getTitle());
    }
}