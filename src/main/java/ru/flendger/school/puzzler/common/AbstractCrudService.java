package ru.flendger.school.puzzler.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, I, R extends JpaRepository<T, I>> implements CrudStorageService<T, I> {
    protected abstract R getRepository();

    @Override
    public Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public void save(T entity) {
        getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }
}
