package ru.flendger.school.puzzler.model.manager;

import ru.flendger.school.puzzler.model.dto.SchoolClassDto;

import java.util.List;

public interface SchoolClassManager {
    List<SchoolClassDto> findAll();

    void save(SchoolClassDto schoolClassDto);

    void delete(SchoolClassDto schoolClassDto);
}