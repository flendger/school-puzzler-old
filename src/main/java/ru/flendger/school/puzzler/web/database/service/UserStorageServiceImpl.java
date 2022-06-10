package ru.flendger.school.puzzler.web.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.web.database.repository.UserRepository;
import ru.flendger.school.puzzler.web.model.entity.User;
import ru.flendger.school.puzzler.web.model.dao.UserStorageService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStorageServiceImpl extends AbstractCrudService<User, Long, UserRepository> implements UserStorageService {
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
