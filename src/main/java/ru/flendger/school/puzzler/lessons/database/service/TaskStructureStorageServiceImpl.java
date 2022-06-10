package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.TaskStructureRepository;
import ru.flendger.school.puzzler.lessons.model.entity.TaskStructure;
import ru.flendger.school.puzzler.lessons.model.dao.TaskStructureStorageService;

@Service
@RequiredArgsConstructor
public class TaskStructureStorageServiceImpl extends AbstractCrudService<TaskStructure, Long, TaskStructureRepository> implements TaskStructureStorageService {
    private final TaskStructureRepository taskStructureRepository;

    @Override
    protected TaskStructureRepository getRepository() {
        return taskStructureRepository;
    }
}
