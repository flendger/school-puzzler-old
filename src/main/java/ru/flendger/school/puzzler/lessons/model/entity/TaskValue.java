package ru.flendger.school.puzzler.lessons.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;
import ru.flendger.school.puzzler.lessons.model.enums.TaskValueType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_values")
public class TaskValue extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "value1")
    private String value1;

    @Column(name = "value2")
    private String value2;

    @Column(name = "value3")
    private String value3;

    @Column(name = "accessible")
    private boolean accessible;

    @ManyToOne
    @JoinColumn(name = "task_column_id")
    private TaskColumn taskColumn;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "value_type")
    private TaskValueType valueType;
}
