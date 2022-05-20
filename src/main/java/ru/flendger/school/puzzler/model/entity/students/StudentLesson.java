package ru.flendger.school.puzzler.model.entity.students;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.model.entity.BaseEntity;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.entity.Student;

import javax.persistence.*;

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
}
