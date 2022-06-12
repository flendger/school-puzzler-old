package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;

public interface StudentLessonKeyRepository extends JpaRepository<StudentLessonKey, Long> {
}
