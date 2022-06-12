package ru.flendger.school.puzzler.students.model.service.lessonlogin.dto;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.students.model.service.schoolclass.dto.SchoolClassDto;

@Getter
@Setter
public class LessonLoginStudentDto {
    private Long id;
    private String name;
    private SchoolClassDto schoolClass;
}
