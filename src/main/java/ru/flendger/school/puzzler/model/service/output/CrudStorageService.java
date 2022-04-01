package ru.flendger.school.puzzler.model.service.output;

import java.util.List;
import java.util.Optional;

public interface CrudStorageService<T, I> {
    Optional<T> findById(I id);

    List<T> findAll();

    void save(T entity);

    void delete(T entity);
}
