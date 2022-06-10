package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.SubjectRepository;
import ru.flendger.school.puzzler.lessons.model.entity.Subject;
import ru.flendger.school.puzzler.lessons.model.dao.SubjectStorageService;

@Service
@RequiredArgsConstructor
public class SubjectStorageServiceImpl extends AbstractCrudService<Subject, Long, SubjectRepository> implements SubjectStorageService {
    private final SubjectRepository subjectRepository;

    @Override
    protected SubjectRepository getRepository() {
        return subjectRepository;
    }
}
