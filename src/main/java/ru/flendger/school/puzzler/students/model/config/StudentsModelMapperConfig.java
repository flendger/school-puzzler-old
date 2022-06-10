package ru.flendger.school.puzzler.students.model.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.flendger.school.puzzler.students.model.config.factory.ModelMapperFactory;

@Configuration
public class StudentsModelMapperConfig {
    @Bean
    public ModelMapper studentsModelMapper(ModelMapperFactory modelMapperFactory) {
        return modelMapperFactory.create();
    }
}
