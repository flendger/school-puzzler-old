package ru.flendger.school.puzzler.students.model.service.lessonkeys.dto;

import lombok.Data;

@Data
public class LessonKeyRequest {
    private Long lessonId;
    private Long schoolClassId;
}
