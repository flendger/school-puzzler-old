package ru.flendger.school.puzzler.students.model.service.lessonlogon.dto;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.students.model.service.schoolclass.dto.SchoolClassDto;

@Getter
@Setter
public class LessonLogonStudentDto {
    private Long id;
    private String name;
    private SchoolClassDto schoolClass;
}
