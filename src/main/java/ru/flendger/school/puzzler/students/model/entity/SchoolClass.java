package ru.flendger.school.puzzler.students.model.entity;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "school_classes")
public class SchoolClass extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "schoolClass", cascade = {PERSIST, MERGE})
    private List<Student> students;
}
