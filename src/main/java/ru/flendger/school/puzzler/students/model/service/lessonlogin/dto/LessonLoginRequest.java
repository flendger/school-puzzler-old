package ru.flendger.school.puzzler.students.model.service.lessonlogin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonLoginRequest {
    private String keyValue;
    private Long studentId;
}
