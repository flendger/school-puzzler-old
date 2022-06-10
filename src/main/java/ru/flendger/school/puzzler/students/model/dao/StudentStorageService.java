package ru.flendger.school.puzzler.students.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.students.model.entity.Student;

import java.util.List;

public interface StudentStorageService extends CrudStorageService<Student, Long> {
    List<Student> findBySchoolClass(String schoolClassName);
    List<Student> findBySchoolClass(Long schoolClassId);
}
