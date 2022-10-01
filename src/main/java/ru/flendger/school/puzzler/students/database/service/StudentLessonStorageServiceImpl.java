package ru.flendger.school.puzzler.students.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.students.database.repository.StudentLessonRepository;
import ru.flendger.school.puzzler.students.model.entity.lesson.StudentLesson;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;

@Service
@RequiredArgsConstructor
public class StudentLessonStorageServiceImpl extends AbstractCrudService<StudentLesson, Long, StudentLessonRepository> implements StudentLessonStorageService {
    private final StudentLessonRepository studentLessonRepository;

    @Override
    protected StudentLessonRepository getRepository() {
        return studentLessonRepository;
    }
}
