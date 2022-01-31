package ru.flendger.school.puzzler.model.manager;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {
        ModelMapper.class,
        StudentLessonManagerImpl.class})
class StudentLessonManagerTest {
    @Autowired
    private StudentLessonManager studentLessonManager;

    @Test
    void getLessons() {
        List<LessonRowDto> lessons = studentLessonManager.getLessons();

        assertFalse(lessons.isEmpty());

        LessonRowDto lessonRowDto = lessons.get(0);
        assertEquals(1L, lessonRowDto.getId());
        assertEquals("lesson name", lessonRowDto.getName());
        assertEquals("lesson title", lessonRowDto.getTitle());
        assertEquals("subject name", lessonRowDto.getSubjectName());
    }
}