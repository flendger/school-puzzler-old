package ru.flendger.school.puzzler.students.model.entity.task;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student_lesson_tasks")
public class StudentLessonTask extends BaseEntity {
    @Column(name = "student_lesson_id")
    private Long studentLessonId;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "task_order_num")
    private int taskOrderNum;

    @ElementCollection
    @CollectionTable(name = "student_task_values", joinColumns = @JoinColumn(name = "student_task_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "valueType", column = @Column(name = "value_type")),
            @AttributeOverride(name = "orderNum", column = @Column(name = "order_num")),
            @AttributeOverride(name = "value1", column = @Column(name = "value1")),
            @AttributeOverride(name = "value2", column = @Column(name = "value2")),
            @AttributeOverride(name = "value3", column = @Column(name = "value3")),
            @AttributeOverride(name = "accessible", column = @Column(name = "accessible"))
    })
    private List<StudentLessonTaskValue> taskValues;
}
