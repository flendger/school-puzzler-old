package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskStructure extends BaseEntity{
    private String name;
    private List<TaskColumn> taskColumns;
}
