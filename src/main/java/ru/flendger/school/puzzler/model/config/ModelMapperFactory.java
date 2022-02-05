package ru.flendger.school.puzzler.model.config;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.entity.Lesson;

@Component
@RequiredArgsConstructor
public class ModelMapperFactory {
    private final Converter<Lesson, LessonDto> lessonToLessonDtoPostConverter;

    public ModelMapper create() {
        ModelMapper modelMapper = new ModelMapper();

        Configuration mapperConfiguration = modelMapper.getConfiguration();
        mapperConfiguration.setSkipNullEnabled(true);

        addTaskStructureToHeaderDtoMap(modelMapper);

        return modelMapper;
    }

    private void addTaskStructureToHeaderDtoMap(ModelMapper modelMapper) {
        TypeMap<Lesson, LessonDto> typeMap = modelMapper.createTypeMap(Lesson.class, LessonDto.class);

        typeMap.addMapping(lesson -> lesson.getTaskStructure().getTaskColumns(), LessonDto::setHeaders);

        typeMap.setPostConverter(lessonToLessonDtoPostConverter);
    }
}
