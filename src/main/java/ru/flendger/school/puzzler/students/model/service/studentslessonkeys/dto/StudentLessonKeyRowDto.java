package ru.flendger.school.puzzler.students.model.service.studentslessonkeys.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentLessonKeyRowDto {
    private Long id;
    private String keyValue;
    private LocalDateTime loginDate;
    private Long studentLessonId;

    private String studentName = "";
    private String lessonName = "";
}
