package ru.flendger.school.puzzler.students.model.service.studentslessonkeys;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.lessons.model.service.lesson.LessonService;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonRowDto;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonKeyStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentLessonStorageService;
import ru.flendger.school.puzzler.students.model.entity.StudentLesson;
import ru.flendger.school.puzzler.students.model.service.studentslessonkeys.dto.StudentLessonKeyRowDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsLessonKeysServiceImpl implements StudentsLessonKeysService {
    private final StudentLessonKeyStorageService studentLessonKeyStorageService;
    private final ModelMapper studentsModelMapper;
    private final StudentLessonStorageService studentLessonStorageService;
    private final LessonService lessonService;
    private final DateTimeService dateTimeService;

    @Override
    public List<StudentLessonKeyRowDto> getActive() {
        return studentLessonKeyStorageService.findActive()
                .stream()
                .map(studentLessonKey -> {
                    StudentLessonKeyRowDto studentLessonKeyRowDto = studentsModelMapper.map(studentLessonKey, StudentLessonKeyRowDto.class);

                    studentLessonKeyRowDto.setLoginDateLocal(dateTimeService.toLocalFormat(studentLessonKey.getLoginDate()));

                    studentLessonStorageService
                            .findById(studentLessonKeyRowDto.getStudentLessonId())
                            .ifPresent(studentLesson -> {
                                studentLessonKeyRowDto.setStudentName(getStudentName(studentLesson));

                                lessonService
                                        .findRowById(studentLesson.getLessonId())
                                        .ifPresent(lessonRowDto -> studentLessonKeyRowDto.setLessonName(getLessonName(lessonRowDto)));
                            });

                    return studentLessonKeyRowDto;
                })
                .collect(Collectors.toList());
    }

    private String getLessonName(LessonRowDto lessonRowDto) {
        return lessonRowDto.getName();
    }

    private String getStudentName(StudentLesson studentLesson) {
        return studentLesson.getStudent().getName();
    }
}
