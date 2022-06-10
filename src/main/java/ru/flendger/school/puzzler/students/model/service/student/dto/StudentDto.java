package ru.flendger.school.puzzler.students.model.service.student.dto;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.students.model.service.schoolclass.dto.SchoolClassDto;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private SchoolClassDto schoolClass;
}
