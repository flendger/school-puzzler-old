package ru.flendger.school.puzzler.lessons.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "task_structure_id")
    private TaskStructure taskStructure;

    @ManyToMany
    @JoinTable(name = "lessons_tasks",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
