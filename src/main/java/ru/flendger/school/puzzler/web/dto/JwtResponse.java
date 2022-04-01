package ru.flendger.school.puzzler.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String username;
    private String token;
    private boolean isAdmin;
}
