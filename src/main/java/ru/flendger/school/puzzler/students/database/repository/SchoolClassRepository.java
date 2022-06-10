package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.students.model.entity.SchoolClass;

import java.util.Optional;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    Optional<SchoolClass> findFirstByNameOrderByIdAsc(String name);
}
