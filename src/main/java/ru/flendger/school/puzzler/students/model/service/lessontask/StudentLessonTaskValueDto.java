package ru.flendger.school.puzzler.students.model.service.lessontask;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLessonTaskValueDto {
    private Long id;
    private String value1;
    private String value2;
    private String value3;
    private boolean accessible;
    private Long columnId;
    private int columnOrder;
    private String valueType;
}
