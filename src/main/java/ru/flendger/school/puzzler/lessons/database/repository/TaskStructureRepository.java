package ru.flendger.school.puzzler.lessons.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.lessons.model.entity.TaskStructure;

public interface TaskStructureRepository extends JpaRepository<TaskStructure, Long> {
}
