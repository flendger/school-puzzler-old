package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.SchoolClassRepository;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.service.SchoolClassService;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl extends AbstractCrudService<SchoolClass, Long, SchoolClassRepository> implements SchoolClassService {
   private final SchoolClassRepository schoolClassRepository;

    @Override
    SchoolClassRepository getRepository() {
        return schoolClassRepository;
    }
}
