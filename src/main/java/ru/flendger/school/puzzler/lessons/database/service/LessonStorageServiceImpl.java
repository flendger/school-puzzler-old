package ru.flendger.school.puzzler.lessons.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.lessons.database.repository.LessonRepository;
import ru.flendger.school.puzzler.lessons.model.entity.lesson.Lesson;
import ru.flendger.school.puzzler.lessons.model.dao.LessonStorageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonStorageServiceImpl extends AbstractCrudService<Lesson, Long, LessonRepository> implements LessonStorageService {
    private final LessonRepository lessonRepository;

    @Override
    protected LessonRepository getRepository() {
        return lessonRepository;
    }

    @Override
    public List<Lesson> findBySubject(Long subjectId) {
        return lessonRepository.findBySubject_Id(subjectId);
    }
}
