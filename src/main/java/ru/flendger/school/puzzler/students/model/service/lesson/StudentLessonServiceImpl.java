package ru.flendger.school.puzzler.students.model.service.lesson;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.lessons.model.service.lesson.LessonService;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonRowDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentLessonServiceImpl implements StudentLessonService {
    private final ModelMapper studentsModelMapper;
    private final LessonService lessonService;

    @Override
    public List<StudentLessonRowDto> getLessons() {
        return lessonService.findAll()
                .stream()
                .map(lesson -> studentsModelMapper.map(lesson, StudentLessonRowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StudentLessonDto> getLesson(Long id) {
        return lessonService.findById(id)
                .map(lesson -> studentsModelMapper.map(lesson, StudentLessonDto.class));
    }
}
