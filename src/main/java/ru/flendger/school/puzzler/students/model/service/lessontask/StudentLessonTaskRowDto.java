package ru.flendger.school.puzzler.students.model.service.lessontask;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentLessonTaskRowDto {
    private Long id;
    private String name;
    private String title;
    private List<StudentLessonTaskValueDto> values;
}
