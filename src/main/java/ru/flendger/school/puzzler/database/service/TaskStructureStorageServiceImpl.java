package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskStructureRepository;
import ru.flendger.school.puzzler.model.entity.TaskStructure;
import ru.flendger.school.puzzler.model.service.output.TaskStructureStorageService;

@Service
@RequiredArgsConstructor
public class TaskStructureStorageServiceImpl extends AbstractCrudService<TaskStructure, Long, TaskStructureRepository> implements TaskStructureStorageService {
    private final TaskStructureRepository taskStructureRepository;

    @Override
    protected TaskStructureRepository getRepository() {
        return taskStructureRepository;
    }
}
