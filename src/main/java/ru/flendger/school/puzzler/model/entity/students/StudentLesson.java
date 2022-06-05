package ru.flendger.school.puzzler.model.entity.students;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.model.entity.BaseEntity;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.entity.Student;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_lessons")
@Getter
@Setter
public class StudentLesson extends BaseEntity {
    @Column(name = "lesson_key")
    private String lessonKey;

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
