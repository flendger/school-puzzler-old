package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Task extends BaseEntity{
    private String name;
    private String title;
    private TaskStructure taskStructure;
    private TaskColumn taskColumn;
    private List<TaskValue> taskValues;
}
