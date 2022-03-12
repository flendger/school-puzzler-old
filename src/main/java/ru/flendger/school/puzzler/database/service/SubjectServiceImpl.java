package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.SubjectRepository;
import ru.flendger.school.puzzler.model.entity.Subject;
import ru.flendger.school.puzzler.model.service.SubjectService;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl extends AbstractCrudService<Subject, Long, SubjectRepository> implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    protected SubjectRepository getRepository() {
        return subjectRepository;
    }
}
