package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.SubjectRepository;
import ru.flendger.school.puzzler.model.entity.Subject;
import ru.flendger.school.puzzler.model.service.output.SubjectStorageService;

@Service
@RequiredArgsConstructor
public class SubjectStorageServiceImpl extends AbstractCrudService<Subject, Long, SubjectRepository> implements SubjectStorageService {
    private final SubjectRepository subjectRepository;

    @Override
    protected SubjectRepository getRepository() {
        return subjectRepository;
    }
}
