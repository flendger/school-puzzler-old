package ru.flendger.school.puzzler.students.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.students.database.repository.StudentLessonTaskRepository;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonTaskStorageService;
import ru.flendger.school.puzzler.students.model.entity.task.StudentLessonTask;

@Service
@RequiredArgsConstructor
public class StudentLessonTaskStorageServiceImpl extends AbstractCrudService<StudentLessonTask, Long, StudentLessonTaskRepository> implements StudentLessonTaskStorageService {
    private final StudentLessonTaskRepository studentLessonTaskRepository;

    @Override
    protected StudentLessonTaskRepository getRepository() {
        return studentLessonTaskRepository;
    }
}
