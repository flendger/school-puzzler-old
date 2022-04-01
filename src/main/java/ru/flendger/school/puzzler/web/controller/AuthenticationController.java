package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.web.config.UserAuthenticationManager;
import ru.flendger.school.puzzler.web.dto.JwtRequest;
import ru.flendger.school.puzzler.web.dto.JwtResponse;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserAuthenticationManager userAuthenticationManager;

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody JwtRequest jwtRequest) {
        try {
            JwtResponse jwtResponse = userAuthenticationManager.authenticate(jwtRequest);

            return ResponseEntity.ok(jwtResponse);
        } catch (AuthenticationException ex) {
            return ResponseMessage.createResponse("Неверное имя пользователя или пароль", HttpStatus.UNAUTHORIZED);
        }
    }
}
