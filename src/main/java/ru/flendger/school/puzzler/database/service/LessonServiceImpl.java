package ru.flendger.school.puzzler.database.service;

import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.service.LessonService;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {
    @Override
    public Optional<Lesson> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Lesson> findAll() {
        return null;
    }

    @Override
    public void save(Lesson entity) {

    }
}
