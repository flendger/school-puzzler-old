package ru.flendger.school.puzzler.model.service.output;

import ru.flendger.school.puzzler.model.entity.SchoolClass;

import java.util.Optional;

public interface SchoolClassStorageService extends CrudStorageService<SchoolClass, Long> {
    Optional<SchoolClass> findByName(String schoolClassName);
}
