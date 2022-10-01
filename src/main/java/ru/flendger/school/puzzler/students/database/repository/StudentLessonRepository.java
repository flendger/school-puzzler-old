package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.lesson.StudentLesson;

import java.util.Optional;

public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
    Optional<StudentLesson> findFirstByStudent_IdAndLessonIdOrderByStartedAtDesc(Long studentId, Long lessonId);
}
