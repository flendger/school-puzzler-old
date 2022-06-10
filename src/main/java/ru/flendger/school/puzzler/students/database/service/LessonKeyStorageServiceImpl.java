package ru.flendger.school.puzzler.students.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.students.database.repository.LessonKeyRepository;
import ru.flendger.school.puzzler.students.model.entity.LessonKey;
import ru.flendger.school.puzzler.students.model.dao.LessonKeyStorageService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonKeyStorageServiceImpl extends AbstractCrudService<LessonKey, Long, LessonKeyRepository> implements LessonKeyStorageService {
    private final LessonKeyRepository lessonKeyRepository;

    @Override
    protected LessonKeyRepository getRepository() {
        return lessonKeyRepository;
    }

    @Override
    public Optional<LessonKey> findActive(String keyValue, LocalDateTime expiredDate) {
        return lessonKeyRepository.findFirstByKeyValueAndExpiredDateIsGreaterThanEqualOrderByIdAsc(keyValue, expiredDate);
    }

    @Override
    public void deleteExpired(LocalDateTime expiredDate) {
        lessonKeyRepository.deleteByExpiredDateLessThan(expiredDate);
    }
}
