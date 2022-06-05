package ru.flendger.school.puzzler.model.dto.students;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonLogonRequest {
    private String keyValue;
    private Long studentId;
}
