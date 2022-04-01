package ru.flendger.school.puzzler.model.service.output;

import ru.flendger.school.puzzler.model.entity.users.User;

import java.util.Optional;

public interface UserStorageService extends CrudStorageService<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findActiveUser(String username);
}
