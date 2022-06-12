package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StudentLessonKeyRepository extends JpaRepository<StudentLessonKey, Long> {
    Optional<StudentLessonKey> findFirstByKeyValueAndStudentIdAndLoginDateIsGreaterThanEqualOrderByLoginDateDesc(String keyValue, Long studentId, LocalDateTime loginDate);
}
