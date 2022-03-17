package ru.flendger.school.puzzler.model.service;

import ru.flendger.school.puzzler.model.entity.users.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Long> {
    Optional<User> findByUsername(String username);
}
