package ru.flendger.school.puzzler.students.model.config.factory;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapperFactory {

    public ModelMapper create() {
        ModelMapper modelMapper = new ModelMapper();

        Configuration mapperConfiguration = modelMapper.getConfiguration();
        mapperConfiguration.setSkipNullEnabled(true);

        return modelMapper;
    }
}
