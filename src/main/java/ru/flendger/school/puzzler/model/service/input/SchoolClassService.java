package ru.flendger.school.puzzler.model.service.input;

import ru.flendger.school.puzzler.model.dto.SchoolClassDto;

import java.util.List;
import java.util.Optional;

public interface SchoolClassService {
    List<SchoolClassDto> findAll();

    Optional<SchoolClassDto> findById(Long id);

    SchoolClassDto create();

    void save(SchoolClassDto schoolClassDto);

    void delete(SchoolClassDto schoolClassDto);
}