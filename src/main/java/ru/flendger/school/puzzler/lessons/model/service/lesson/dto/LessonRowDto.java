package ru.flendger.school.puzzler.lessons.model.service.lesson.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonRowDto {
    private Long id;
    private String name;
    private String title;
    private String subjectName;
}
