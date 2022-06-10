package ru.flendger.school.puzzler.students.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.students.model.entity.SchoolClass;

import java.util.Optional;

public interface SchoolClassStorageService extends CrudStorageService<SchoolClass, Long> {
    Optional<SchoolClass> findByName(String schoolClassName);
}
