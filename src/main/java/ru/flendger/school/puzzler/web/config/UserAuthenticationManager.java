package ru.flendger.school.puzzler.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.web.dto.JwtRequest;
import ru.flendger.school.puzzler.web.util.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class UserAuthenticationManager {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserSecurityService userSecurityService;

    public String authenticate(JwtRequest jwtRequest) throws AuthenticationException {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()));

        UserDetails userDetails = userSecurityService.loadUserByUsername(jwtRequest.getUsername());
        return jwtTokenUtil.generateToken(userDetails);
    }
}
