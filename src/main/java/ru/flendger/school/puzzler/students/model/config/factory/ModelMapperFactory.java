package ru.flendger.school.puzzler.students.model.config.factory;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.lessons.model.service.lesson.dto.LessonDto;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.lessons.model.entity.Lesson;

@Component
@RequiredArgsConstructor
public class ModelMapperFactory {
    private final Converter<LessonDto, StudentLessonDto> lessonDtoToStudentLessonDtoPostConverter;

    public ModelMapper create() {
        ModelMapper modelMapper = new ModelMapper();

        Configuration mapperConfiguration = modelMapper.getConfiguration();
        mapperConfiguration.setSkipNullEnabled(true);

        addTaskStructureToHeaderDtoMap(modelMapper);

        return modelMapper;
    }

    private void addTaskStructureToHeaderDtoMap(ModelMapper modelMapper) {
        // TODO: 10.06.2022 e.kiru -> add type map
//        TypeMap<LessonDto, StudentLessonDto> typeMap = modelMapper.createTypeMap(Lesson.class, StudentLessonDto.class);
//
//        typeMap.addMapping(lesson -> lesson.getTaskStructure().getTaskColumns(), StudentLessonDto::setHeaders);
//
//        typeMap.setPostConverter(lessonDtoToStudentLessonDtoPostConverter);
    }
}
