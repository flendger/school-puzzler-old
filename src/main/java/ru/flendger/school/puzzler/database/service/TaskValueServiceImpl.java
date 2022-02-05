package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskValueRepository;
import ru.flendger.school.puzzler.model.entity.TaskValue;
import ru.flendger.school.puzzler.model.service.TaskValueService;

@Service
@RequiredArgsConstructor
public class TaskValueServiceImpl extends AbstractCrudService<TaskValue, Long, TaskValueRepository> implements TaskValueService {
    private final TaskValueRepository taskValueRepository;

    @Override
    TaskValueRepository getRepository() {
        return taskValueRepository;
    }
}
