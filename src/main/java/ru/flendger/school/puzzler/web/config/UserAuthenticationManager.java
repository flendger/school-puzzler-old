package ru.flendger.school.puzzler.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.settings.AdminTokenExpiredTimeSetting;
import ru.flendger.school.puzzler.settings.ApplicationSettingsService;
import ru.flendger.school.puzzler.web.dto.JwtRequest;
import ru.flendger.school.puzzler.web.dto.JwtResponse;
import ru.flendger.school.puzzler.web.util.JwtTokenUtil;

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
}
