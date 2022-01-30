package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.model.enums.TaskValueType;

@Getter
@Setter
public class TaskValue extends BaseEntity{
    private Task task;
    private String value1;
    private String value2;
    private String value3;
    private boolean accesable;
    private TaskColumn taskColumn;
    private TaskValueType valueType;
}
