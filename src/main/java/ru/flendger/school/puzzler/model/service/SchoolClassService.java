package ru.flendger.school.puzzler.model.service;

import ru.flendger.school.puzzler.model.entity.SchoolClass;

import java.util.Optional;

public interface SchoolClassService extends CrudService<SchoolClass, Long> {
    Optional<SchoolClass> findByName(String schoolClassName);
}
