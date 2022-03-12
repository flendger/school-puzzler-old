package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.SchoolClassRepository;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.service.SchoolClassService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl extends AbstractCrudService<SchoolClass, Long, SchoolClassRepository> implements SchoolClassService {
   private final SchoolClassRepository schoolClassRepository;

    @Override
    protected SchoolClassRepository getRepository() {
        return schoolClassRepository;
    }

    @Override
    public Optional<SchoolClass> findByName(String schoolClassName) {
        return schoolClassRepository.findFirstByNameOrderByIdAsc(schoolClassName);
    }
}
