package ru.flendger.school.puzzler.students.model.service.lessonlogon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonLogonRequest {
    private String keyValue;
    private Long studentId;
}
