package ru.flendger.school.puzzler.web.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.web.model.entity.User;

import java.util.Optional;

public interface UserStorageService extends CrudStorageService<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findActiveUser(String username);
}
