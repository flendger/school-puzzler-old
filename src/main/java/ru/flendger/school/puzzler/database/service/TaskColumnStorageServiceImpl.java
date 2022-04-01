package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskColumnRepository;
import ru.flendger.school.puzzler.model.entity.TaskColumn;
import ru.flendger.school.puzzler.model.service.output.TaskColumnStorageService;

@Service
@RequiredArgsConstructor
public class TaskColumnStorageServiceImpl extends AbstractCrudService<TaskColumn, Long, TaskColumnRepository> implements TaskColumnStorageService {
    private final TaskColumnRepository taskColumnRepository;

    @Override
    protected TaskColumnRepository getRepository() {
        return taskColumnRepository;
    }
}
