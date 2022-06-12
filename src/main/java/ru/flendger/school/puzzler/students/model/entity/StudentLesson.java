package ru.flendger.school.puzzler.students.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;
import ru.flendger.school.puzzler.lessons.model.entity.Lesson;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_lessons")
@Getter
@Setter
public class StudentLesson extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;
}
