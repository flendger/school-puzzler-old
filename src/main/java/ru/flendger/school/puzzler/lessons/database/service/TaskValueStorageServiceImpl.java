package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.TaskValueRepository;
import ru.flendger.school.puzzler.lessons.model.entity.TaskValue;
import ru.flendger.school.puzzler.lessons.model.dao.TaskValueStorageService;

@Service
@RequiredArgsConstructor
public class TaskValueStorageServiceImpl extends AbstractCrudService<TaskValue, Long, TaskValueRepository> implements TaskValueStorageService {
    private final TaskValueRepository taskValueRepository;

    @Override
    protected TaskValueRepository getRepository() {
        return taskValueRepository;
    }
}
