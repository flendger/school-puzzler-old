package ru.flendger.school.puzzler.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.entity.TaskColumn;

public interface TaskColumnRepository extends JpaRepository<TaskColumn, Long> {
}
