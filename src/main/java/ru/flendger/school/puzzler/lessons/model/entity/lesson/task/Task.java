package ru.flendger.school.puzzler.lessons.model.entity.lesson.task;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;
import ru.flendger.school.puzzler.lessons.model.entity.lesson.Lesson;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "title")
    private String title;

    @Column(name = "task_order_num")
    private int taskOrderNum;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskValue> taskValues;
}
