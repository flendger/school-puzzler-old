package ru.flendger.school.puzzler.students.model.entity;

import lombok.*;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_lesson_keys")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentLessonKey extends BaseEntity {
    @Column(name = "key_value")
    private String keyValue;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "login_date")
    private LocalDateTime loginDate;
}
