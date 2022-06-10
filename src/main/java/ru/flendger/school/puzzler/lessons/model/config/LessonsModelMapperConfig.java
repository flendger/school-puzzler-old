package ru.flendger.school.puzzler.lessons.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LessonsModelMapperConfig {
    @Bean
    public ModelMapper lessonsModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        return modelMapper;
    }
}
