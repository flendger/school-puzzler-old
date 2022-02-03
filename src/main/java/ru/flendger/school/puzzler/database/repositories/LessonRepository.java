package ru.flendger.school.puzzler.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
