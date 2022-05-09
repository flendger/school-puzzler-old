package ru.flendger.school.puzzler.model.service.output;

import ru.flendger.school.puzzler.model.entity.Student;

import java.util.List;

public interface StudentStorageService extends CrudStorageService<Student, Long> {
    List<Student> findBySchoolClass(String schoolClassName);
    List<Student> findBySchoolClass(Long schoolClassId);
}
