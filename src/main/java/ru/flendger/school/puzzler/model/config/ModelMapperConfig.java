package ru.flendger.school.puzzler.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration mapperConfiguration = modelMapper.getConfiguration();
        mapperConfiguration.setSkipNullEnabled(true);

        return modelMapper;
    }
}
