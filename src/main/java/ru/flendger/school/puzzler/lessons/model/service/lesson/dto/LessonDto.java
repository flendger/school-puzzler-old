package ru.flendger.school.puzzler.lessons.model.service.lesson.dto;

import lombok.Data;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonHeaderDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonTaskRowDto;

import java.util.List;

@Data
public class LessonDto {
    private Long id;
    private String name;
    private String title;
    private List<StudentLessonHeaderDto> headers;
    private List<StudentLessonTaskRowDto> tasks;
}
