package ru.flendger.school.puzzler.students.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_lesson_keys")
@Getter
@Setter
public class StudentLessonKey extends BaseEntity {
    @Column(name = "key_value")
    private String keyValue;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "login_date")
    private LocalDateTime loginDate;

    @Column(name = "student_lesson_id")
    private Long studentLessonId;
}
