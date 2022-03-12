package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskRepository;
import ru.flendger.school.puzzler.model.entity.Task;
import ru.flendger.school.puzzler.model.service.TaskService;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl extends AbstractCrudService<Task, Long, TaskRepository> implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    protected TaskRepository getRepository() {
        return taskRepository;
    }
}
