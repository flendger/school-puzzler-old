package ru.flendger.school.puzzler.students.model.service.lesson.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLessonRowDto {
    private Long id;
    private String name;
    private String title;
    private String subjectName;
}
