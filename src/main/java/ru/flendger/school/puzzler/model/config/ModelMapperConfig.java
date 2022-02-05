package ru.flendger.school.puzzler.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.flendger.school.puzzler.model.config.factory.ModelMapperFactory;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(ModelMapperFactory modelMapperFactory) {
        return modelMapperFactory.create();
    }
}
