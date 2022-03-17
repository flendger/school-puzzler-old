package ru.flendger.school.puzzler.model.manager;

import ru.flendger.school.puzzler.model.dto.StudentDto;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface StudentManager {
    List<StudentDto> findALl();

    List<StudentDto> findBySchoolClass(String schoolClassName);

    Optional<StudentDto> findById(Long id);

    StudentDto create();

    void save(StudentDto studentDto);

    void delete(StudentDto studentDto);

    void saveStudents(InputStream inputStream) throws IOException, EntityNotFoundException;
}
