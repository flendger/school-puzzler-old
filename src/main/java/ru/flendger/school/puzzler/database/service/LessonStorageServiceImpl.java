package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.LessonRepository;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.service.output.LessonStorageService;

@Service
@RequiredArgsConstructor
public class LessonStorageServiceImpl extends AbstractCrudService<Lesson, Long, LessonRepository> implements LessonStorageService {
    private final LessonRepository lessonRepository;

    @Override
    protected LessonRepository getRepository() {
        return lessonRepository;
    }
}
