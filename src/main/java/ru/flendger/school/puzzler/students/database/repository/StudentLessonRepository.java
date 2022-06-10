package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.StudentLesson;

public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
}
