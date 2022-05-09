package ru.flendger.school.puzzler.model.service.input;

import ru.flendger.school.puzzler.model.dto.StudentDto;

import java.util.List;

public interface LessonLoginService {
    List<StudentDto> findByLessonKey(String keyValue);
}
