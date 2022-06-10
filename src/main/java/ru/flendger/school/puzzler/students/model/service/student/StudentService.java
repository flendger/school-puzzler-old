package ru.flendger.school.puzzler.students.model.service.student;

import ru.flendger.school.puzzler.students.model.service.student.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> findAll();

    List<StudentDto> findBySchoolClass(String schoolClassName);

    Optional<StudentDto> findById(Long id);

    StudentDto create();

    void save(StudentDto studentDto);

    void delete(StudentDto studentDto);
}
