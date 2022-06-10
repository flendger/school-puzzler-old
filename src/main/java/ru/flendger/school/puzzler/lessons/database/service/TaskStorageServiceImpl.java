package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.TaskRepository;
import ru.flendger.school.puzzler.lessons.model.entity.Task;
import ru.flendger.school.puzzler.lessons.model.dao.TaskStorageService;

@Service
@RequiredArgsConstructor
public class TaskStorageServiceImpl extends AbstractCrudService<Task, Long, TaskRepository> implements TaskStorageService {
    private final TaskRepository taskRepository;

    @Override
    protected TaskRepository getRepository() {
        return taskRepository;
    }
}
