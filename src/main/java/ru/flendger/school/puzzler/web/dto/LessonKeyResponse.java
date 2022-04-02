package ru.flendger.school.puzzler.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LessonKeyResponse {
    private String keyValue;
    private Long lessonId;
    private Long schoolClassId;
    private LocalDateTime expiredDate;
}
