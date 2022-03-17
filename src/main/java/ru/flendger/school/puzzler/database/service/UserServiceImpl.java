package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.UserRepository;
import ru.flendger.school.puzzler.model.entity.users.User;
import ru.flendger.school.puzzler.model.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractCrudService<User, Long, UserRepository> implements UserService {
    private final UserRepository userRepository;

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findActiveUser(String username) {
        return userRepository.findByUsernameAndActiveTrue(username);
    }
}
