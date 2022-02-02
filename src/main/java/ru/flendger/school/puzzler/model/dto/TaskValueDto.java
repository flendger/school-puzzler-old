package ru.flendger.school.puzzler.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskValueDto {
    private Long id;
    private String value1;
    private String value2;
    private String value3;
    private boolean accesable;
    private Long columnId;
    private String valueType;
}
