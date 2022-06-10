package ru.flendger.school.puzzler.students.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;

import java.time.LocalDateTime;
import java.util.Optional;

public interface LessonKeyRepository extends JpaRepository<LessonKey, Long> {
    Optional<LessonKey> findFirstByKeyValueAndExpiredDateIsGreaterThanEqualOrderByIdAsc(String keyValue, LocalDateTime expiredDate);

    @Transactional
    @Modifying
    @Query("delete from LessonKey l where l.expiredDate < ?1")
    void deleteByExpiredDateLessThan(LocalDateTime expiredDate);
}
