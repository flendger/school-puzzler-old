package ru.flendger.school.puzzler.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskRowDto {
    private Long taskId;
    private String name;
    private String title;
    private List<TaskValueDto> values;
}
