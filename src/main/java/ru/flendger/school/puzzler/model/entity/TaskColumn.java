package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskColumn extends BaseEntity{
    private TaskStructure taskStructure;
    private int order;
    private String name;
}
