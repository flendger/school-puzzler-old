package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.TaskColumnRepository;
import ru.flendger.school.puzzler.lessons.model.entity.TaskColumn;
import ru.flendger.school.puzzler.lessons.model.dao.TaskColumnStorageService;

@Service
@RequiredArgsConstructor
public class TaskColumnStorageServiceImpl extends AbstractCrudService<TaskColumn, Long, TaskColumnRepository> implements TaskColumnStorageService {
    private final TaskColumnRepository taskColumnRepository;

    @Override
    protected TaskColumnRepository getRepository() {
        return taskColumnRepository;
    }
}
