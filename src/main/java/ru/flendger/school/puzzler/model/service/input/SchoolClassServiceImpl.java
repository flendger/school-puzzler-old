package ru.flendger.school.puzzler.model.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.dto.SchoolClassDto;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.service.output.SchoolClassStorageService;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {
    private final SchoolClassStorageService schoolClassStorageService;
    private final ModelMapper modelMapper;

    @Override
    public List<SchoolClassDto> findAll() {
        return schoolClassStorageService
                .findAll()
                .stream()
                .map(schoolClass -> modelMapper.map(schoolClass, SchoolClassDto.class))
                .sorted(Comparator.comparingLong(SchoolClassDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SchoolClassDto> findById(Long id) {
        return schoolClassStorageService.findById(id).map(schoolClass -> modelMapper.map(schoolClass, SchoolClassDto.class));
    }

    @Override
    public SchoolClassDto create() {
        return new SchoolClassDto();
    }

    @Override
    @Transactional
    public void save(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass;

        if (Objects.nonNull(schoolClassDto.getId())) {
            schoolClass = schoolClassStorageService.findById(schoolClassDto.getId())
                    .orElseThrow(() -> createEntityNotFoundException(schoolClassDto));

            modelMapper.map(schoolClassDto, schoolClass);
        } else {
            schoolClass = modelMapper.map(schoolClassDto, SchoolClass.class);
        }

        schoolClassStorageService.save(schoolClass);
    }

    private EntityNotFoundException createEntityNotFoundException(SchoolClassDto schoolClassDto) {
        return new EntityNotFoundException(messageSchoolClassNotFound(schoolClassDto));
    }

    private String messageSchoolClassNotFound(SchoolClassDto schoolClassDto) {
        return String.format("School class not found ID [%d]", schoolClassDto.getId());
    }

    @Override
    public void delete(SchoolClassDto schoolClassDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassDto, SchoolClass.class);

        schoolClassStorageService.delete(schoolClass);
    }
}
