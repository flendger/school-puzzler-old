package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.StudentLessonRepository;
import ru.flendger.school.puzzler.model.entity.students.StudentLesson;
import ru.flendger.school.puzzler.model.service.output.StudentLessonStorageService;

@Service
@RequiredArgsConstructor
public class StudentLessonStorageServiceImpl extends AbstractCrudService<StudentLesson, Long, StudentLessonRepository> implements StudentLessonStorageService {
    private final StudentLessonRepository studentLessonRepository;

    @Override
    protected StudentLessonRepository getRepository() {
        return studentLessonRepository;
    }
}
