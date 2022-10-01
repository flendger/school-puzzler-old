package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.task.StudentLessonTask;

public interface StudentLessonTaskRepository extends JpaRepository<StudentLessonTask, Long> {
}
