package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {
    @Column(name = "name")
    private String name;
}
