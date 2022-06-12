package ru.flendger.school.puzzler.students.model.entity;

import lombok.*;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_lessons")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentLesson extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;
}
