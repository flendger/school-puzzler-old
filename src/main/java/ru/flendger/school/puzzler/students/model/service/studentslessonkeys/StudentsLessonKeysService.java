package ru.flendger.school.puzzler.students.model.service.studentslessonkeys;

import ru.flendger.school.puzzler.students.model.service.studentslessonkeys.dto.StudentLessonKeyRowDto;

import java.util.List;

public interface StudentsLessonKeysService {
    List<StudentLessonKeyRowDto> getActive();
}
