package ru.flendger.school.puzzler.students.model.service.lessonlogon;

import ru.flendger.school.puzzler.students.model.service.lessonlogon.dto.LessonLogonStudentDto;

import java.util.List;

public interface LessonLogonService {
    List<LessonLogonStudentDto> findStudentsByLessonKey(String keyValue);
}
