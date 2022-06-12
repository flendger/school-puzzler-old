package ru.flendger.school.puzzler.students.model.service.lessonlogin;

import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginStudentDto;

import java.util.List;

public interface LessonLoginService {
    List<LessonLoginStudentDto> findStudentsByLessonKey(String keyValue);
}
