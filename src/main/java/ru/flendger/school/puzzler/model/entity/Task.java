package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "task_structure_id")
    private TaskStructure taskStructure;

    @ManyToOne
    @JoinColumn(name = "task_column_id")
    private TaskColumn taskColumn;

    @OneToMany(mappedBy = "task")
    private List<TaskValue> taskValues;
}
