package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    List<Student> findBySchoolClass_NameLike(String schoolClassName);

    List<Student> findBySchoolClass_Id(Long id);
}
