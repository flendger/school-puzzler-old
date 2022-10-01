package ru.flendger.school.puzzler.students.model.entity.lesson;

import lombok.*;
import ru.flendger.school.puzzler.common.BaseEntity;
import ru.flendger.school.puzzler.students.model.entity.Student;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "student_lesson_columns", joinColumns = @JoinColumn(name = "student_lesson_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "orderNum", column = @Column(name = "order_num")),
            @AttributeOverride(name = "title", column = @Column(name = "title"))
    })
    private List<StudentLessonColumn> lessonColumns;
}
