package ru.flendger.school.puzzler.model.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.entity.Lesson;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration mapperConfiguration = modelMapper.getConfiguration();
        mapperConfiguration.setSkipNullEnabled(true);

        TypeMap<Lesson, LessonDto> typeMap = modelMapper.createTypeMap(Lesson.class, LessonDto.class);
        typeMap.addMapping(lesson -> lesson.getTaskStructure().getTaskColumns(), LessonDto::setHeaders);

        return modelMapper;
    }
}
