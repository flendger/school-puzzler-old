package ru.flendger.school.puzzler.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Lesson extends BaseEntity{
    private String name;
    private String title;
    private TaskStructure taskStructure;
    private List<Task> tasks;
    private Subject subject;
}
