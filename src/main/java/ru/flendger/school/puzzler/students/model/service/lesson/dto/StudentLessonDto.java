package ru.flendger.school.puzzler.students.model.service.lesson.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentLessonDto {
    private Long id;
    private String name;
    private String title;
    private List<StudentLessonHeaderDto> headers;
    private List<StudentLessonTaskRowDto> tasks;
}
