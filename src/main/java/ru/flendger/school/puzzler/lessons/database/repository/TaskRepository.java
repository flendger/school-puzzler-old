package ru.flendger.school.puzzler.lessons.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.lessons.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
