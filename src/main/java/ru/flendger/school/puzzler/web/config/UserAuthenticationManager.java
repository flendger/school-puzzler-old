package ru.flendger.school.puzzler.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.settings.AdminTokenExpiredTimeSetting;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.settings.StudentTokenExpiredTimeSetting;
import ru.flendger.school.puzzler.web.dto.JwtRequest;
import ru.flendger.school.puzzler.web.dto.JwtResponse;
import ru.flendger.school.puzzler.web.model.entity.enums.RoleType;
import ru.flendger.school.puzzler.web.util.JwtTokenUtil;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserAuthenticationManager {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserSecurityService userSecurityService;
    private final ApplicationSettingsService applicationSettingsService;

    public JwtResponse authenticate(JwtRequest jwtRequest) throws AuthenticationException {
        String username = jwtRequest.getUsername();

        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            jwtRequest.getPassword()));

        UserDetails userDetails = userSecurityService.loadUserByUsername(username);

        AdminTokenExpiredTimeSetting setting = applicationSettingsService.getSetting(AdminTokenExpiredTimeSetting.class);
        String token = jwtTokenUtil.generateToken(userDetails, setting.getValue() * 1000L);

        return new JwtResponse(username, token, jwtTokenUtil.isAdmin(userDetails));
    }

    public JwtResponse authenticate(Long studentId) {
        String username = studentId.toString();

        UserDetails userDetails = new User(username, "", Collections.singleton(new SimpleGrantedAuthority(RoleType.ROLE_STUDENT.toString())));

        StudentTokenExpiredTimeSetting setting = applicationSettingsService.getSetting(StudentTokenExpiredTimeSetting.class);
        String token = jwtTokenUtil.generateToken(userDetails, setting.getValue() * 1000L);

        return new JwtResponse(username, token, jwtTokenUtil.isAdmin(userDetails));
    }
}
