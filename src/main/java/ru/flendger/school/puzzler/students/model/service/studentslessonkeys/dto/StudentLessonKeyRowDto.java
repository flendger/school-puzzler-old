package ru.flendger.school.puzzler.students.model.service.studentslessonkeys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLessonKeyRowDto {
    private Long id;
    private String keyValue;
    private String loginDateLocal;
    private Long studentLessonId;

    private String studentName = "";
    private String lessonName = "";
}
