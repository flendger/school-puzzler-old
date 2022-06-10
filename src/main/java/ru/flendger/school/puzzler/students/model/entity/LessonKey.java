package ru.flendger.school.puzzler.students.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "lesson_keys")
@Getter
@Setter
public class LessonKey extends BaseEntity {
    @Column(name = "key_value")
    private String keyValue;

    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "class_id")
    private Long schoolClassId;

    @Column(name = "expired_date")
    private LocalDateTime expiredDate;
}
