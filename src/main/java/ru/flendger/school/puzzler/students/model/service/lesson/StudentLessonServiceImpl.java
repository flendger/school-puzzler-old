package ru.flendger.school.puzzler.students.model.service.lesson;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.lessons.model.service.lesson.LessonService;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonDto;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;
import ru.flendger.school.puzzler.students.model.entity.lesson.StudentLesson;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudentLessonServiceImpl implements StudentLessonService {
    private final ModelMapper studentsModelMapper;
    private final LessonService lessonService;
    private final StudentLessonStorageService studentLessonStorageService;

    @Override
    @Transactional(readOnly = true)
    public StudentLessonDto getLesson(Long id) {
        StudentLesson studentLesson =
                studentLessonStorageService.findById(id)
                        .orElseThrow(() -> createLessonNotFoundException(id));

        StudentLessonDto studentLessonDto = studentsModelMapper.map(studentLesson, StudentLessonDto.class);

        LessonDto lessonDto = lessonService.findById(studentLesson.getLessonId())
                .orElseThrow(() -> createLessonNotFoundException(id));

        studentLessonDto.setName(lessonDto.getName());
        studentLessonDto.setTitle(lessonDto.getTitle());

        return studentLessonDto;
    }

    private static EntityNotFoundException createLessonNotFoundException(Long id) {
        return new EntityNotFoundException(messageLessonNotFound(id));
    }

    private static String messageLessonNotFound(Long id) {
        return String.format("Student lesson doesn't exist: %d", id);
    }
}
