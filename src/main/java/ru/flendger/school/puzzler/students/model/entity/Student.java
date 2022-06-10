package ru.flendger.school.puzzler.students.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}
