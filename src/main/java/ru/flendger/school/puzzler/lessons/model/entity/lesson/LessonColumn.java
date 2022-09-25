package ru.flendger.school.puzzler.lessons.model.entity.lesson;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "lesson_columns")
public class LessonColumn extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "title")
    private String title;
}
