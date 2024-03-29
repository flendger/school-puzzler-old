package ru.flendger.school.puzzler.lessons.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;
import ru.flendger.school.puzzler.lessons.model.enums.TaskValueType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_columns")
public class TaskColumn extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "task_structure_id")
    private TaskStructure taskStructure;

    @Column(name = "col_order")
    private int order;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "value_type")
    private TaskValueType valueType;
}
