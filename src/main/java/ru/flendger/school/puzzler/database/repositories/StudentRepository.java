package ru.flendger.school.puzzler.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    List<Student> findBySchoolClass(SchoolClass schoolClass);
}
