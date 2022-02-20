package ru.flendger.school.puzzler.model.manager;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.dto.SchoolClassDto;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.service.SchoolClassService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolClassManagerImpl implements SchoolClassManager {
    private final SchoolClassService schoolClassService;
    private final ModelMapper modelMapper;

    @Override
    public List<SchoolClassDto> findAll() {
        return schoolClassService
                .findAll()
                .stream()
                .map(schoolClass -> modelMapper.map(schoolClass, SchoolClassDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassDto, SchoolClass.class);

        schoolClassService.save(schoolClass);
    }

    @Override
    public void delete(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassDto, SchoolClass.class);

        schoolClassService.delete(schoolClass);
    }
}
