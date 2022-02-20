package ru.flendger.school.puzzler.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private SchoolClassDto schoolClass;
}
