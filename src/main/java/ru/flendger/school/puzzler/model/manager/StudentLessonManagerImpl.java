package ru.flendger.school.puzzler.model.manager;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.LessonRowDto;
import ru.flendger.school.puzzler.model.entity.Lesson;
import ru.flendger.school.puzzler.model.entity.Subject;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentLessonManagerImpl implements StudentLessonManager {
    private final ModelMapper modelMapper;

    @Override
    public List<LessonRowDto> getLessons() {
        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setName("lesson name");
        lesson.setTitle("lesson title");

        Subject subject = new Subject();
        subject.setName("subject name");
        lesson.setSubject(subject);

        return List.of(modelMapper.map(lesson, LessonRowDto.class));
    }

    @Override
    public LessonDto getLesson(Long id) {
        return null;
    }
}
