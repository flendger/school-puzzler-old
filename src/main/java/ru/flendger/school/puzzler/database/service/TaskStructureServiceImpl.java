package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.TaskStructureRepository;
import ru.flendger.school.puzzler.model.entity.TaskStructure;
import ru.flendger.school.puzzler.model.service.TaskStructureService;

@Service
@RequiredArgsConstructor
public class TaskStructureServiceImpl extends AbstractCrudService<TaskStructure, Long, TaskStructureRepository> implements TaskStructureService {
    private final TaskStructureRepository taskStructureRepository;

    @Override
    TaskStructureRepository getRepository() {
        return taskStructureRepository;
    }
}
