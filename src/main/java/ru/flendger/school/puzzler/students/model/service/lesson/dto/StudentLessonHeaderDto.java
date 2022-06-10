package ru.flendger.school.puzzler.students.model.service.lesson.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLessonHeaderDto {
    private Long id;
    private int order;
    private String name;
    private String valueType;
}
