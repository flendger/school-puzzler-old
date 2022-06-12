package ru.flendger.school.puzzler.students.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.students.database.repository.StudentLessonKeyRepository;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.entity.StudentLessonKey;

@Service
@RequiredArgsConstructor
public class StudentLessonKeyStorageServiceImpl extends AbstractCrudService<StudentLessonKey, Long, StudentLessonKeyRepository> implements StudentLessonKeyStorageService {
    private final StudentLessonKeyRepository studentLessonKeyRepository;

    @Override
    protected StudentLessonKeyRepository getRepository() {
        return studentLessonKeyRepository;
    }
}
