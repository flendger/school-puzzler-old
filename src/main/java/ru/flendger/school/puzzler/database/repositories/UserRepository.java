package ru.flendger.school.puzzler.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.entity.users.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
