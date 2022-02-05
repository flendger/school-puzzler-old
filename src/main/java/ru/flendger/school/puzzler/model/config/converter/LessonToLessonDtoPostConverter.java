package ru.flendger.school.puzzler.model.config.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.dto.TaskValueDto;
import ru.flendger.school.puzzler.model.entity.Lesson;

import java.util.Comparator;

@Component
public class LessonToLessonDtoPostConverter implements Converter<Lesson, LessonDto> {
    @Override
    public LessonDto convert(MappingContext<Lesson, LessonDto> mappingContext) {
        LessonDto lessonDto = mappingContext.getDestination();

        lessonDto.getTasks().forEach(taskRowDto ->
                taskRowDto
                        .getValues()
                        .sort(Comparator.comparingInt(TaskValueDto::getColumnOrder)));

        return lessonDto;
    }
}
