package ru.flendger.school.puzzler.students.model.config.factory.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonTaskValueDto;

import java.util.Comparator;

@Component
public class LessonDtoToStudentLessonDtoPostConverter implements Converter<LessonDto, StudentLessonDto> {
    @Override
    public StudentLessonDto convert(MappingContext<LessonDto, StudentLessonDto> mappingContext) {
        StudentLessonDto studentLessonDto = mappingContext.getDestination();

        studentLessonDto.getTasks().forEach(taskRowDto ->
                taskRowDto
                        .getValues()
                        .sort(Comparator.comparingInt(StudentLessonTaskValueDto::getColumnOrder)));

        return studentLessonDto;
    }
}
