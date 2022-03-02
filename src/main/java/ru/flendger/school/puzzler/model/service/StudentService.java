package ru.flendger.school.puzzler.model.service;

import ru.flendger.school.puzzler.model.entity.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long> {
    List<Student> findBySchoolClass(String schoolClassName);
}
