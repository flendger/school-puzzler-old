package ru.flendger.school.puzzler.common;

import java.util.List;
import java.util.Optional;

public interface CrudStorageService<T, I> {
    Optional<T> findById(I id);

    List<T> findAll();

    T save(T entity);

    T saveAndFlush(T entity);

    void delete(T entity);
}
