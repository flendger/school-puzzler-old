package ru.flendger.school.puzzler.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class LessonKeyResponse {
    private String keyValue;
    private Long lessonId;
    private String lessonName;
    private Long schoolClassId;
    private String schoolClassName;
    private LocalDateTime expiredDate;
}
