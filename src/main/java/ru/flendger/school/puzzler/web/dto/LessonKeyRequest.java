package ru.flendger.school.puzzler.web.dto;

import lombok.Data;

@Data
public class LessonKeyRequest {
    private Long lessonId;
    private Long schoolClassId;
}
