package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskColumnRepository;
import ru.flendger.school.puzzler.model.entity.TaskColumn;
import ru.flendger.school.puzzler.model.service.TaskColumnService;

@Service
@RequiredArgsConstructor
public class TaskColumnServiceImpl extends AbstractCrudService<TaskColumn, Long, TaskColumnRepository> implements TaskColumnService {
    private final TaskColumnRepository taskColumnRepository;

    @Override
    protected TaskColumnRepository getRepository() {
        return taskColumnRepository;
    }
}
