package ru.flendger.school.puzzler.model.entity;

import lombok.Data;

@Data
public class LessonKeyRequest {
    private Long lessonId;
    private Long schoolClassId;
}
