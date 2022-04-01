package ru.flendger.school.puzzler.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.entity.users.Role;
import ru.flendger.school.puzzler.model.service.output.UserStorageService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserStorageService userStorageService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userStorageService.findActiveUser(username)
                .map(userDB ->
                        new User(
                                userDB.getUsername(),
                                userDB.getPassword(),
                                mapRolesToAuthorities(userDB.getRoles())))
                .orElseThrow(() -> createUsernameNotFoundException(username));
    }

    private UsernameNotFoundException createUsernameNotFoundException(String username) {
        return new UsernameNotFoundException(messageUserNotFound(username));
    }

    private String messageUserNotFound(String username) {
        return String.format("User [%s] not found", username);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
