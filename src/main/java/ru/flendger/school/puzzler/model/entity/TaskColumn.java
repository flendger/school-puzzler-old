package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_columns")
public class TaskColumn extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "task_structure_id")
    private TaskStructure taskStructure;

    @Column(name = "col_order")
    private int order;

    @Column(name = "name")
    private String name;
}
