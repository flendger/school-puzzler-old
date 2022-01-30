package ru.flendger.school.puzzler.model.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, I> {
    Optional<T> findById(I id);
    List<T> findAll();
    void save(T entity);
}
