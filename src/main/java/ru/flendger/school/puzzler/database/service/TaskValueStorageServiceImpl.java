package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskValueRepository;
import ru.flendger.school.puzzler.model.entity.TaskValue;
import ru.flendger.school.puzzler.model.service.output.TaskValueStorageService;

@Service
@RequiredArgsConstructor
public class TaskValueStorageServiceImpl extends AbstractCrudService<TaskValue, Long, TaskValueRepository> implements TaskValueStorageService {
    private final TaskValueRepository taskValueRepository;

    @Override
    protected TaskValueRepository getRepository() {
        return taskValueRepository;
    }
}
