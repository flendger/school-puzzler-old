package ru.flendger.school.puzzler.database.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.service.CrudService;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, I, R extends JpaRepository<T, I>> implements CrudService<T, I> {
    abstract R getRepository();

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
