package ru.flendger.school.puzzler.model.service.input.lessonkeys.generator;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class KeyGenerator {

    private static final String NUMBER = "0123456789";

    private static final String PASSWORD_ALLOW_BASE = NUMBER;

    public String generate() {
        SecureRandom random = new SecureRandom();
        int length = 6;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(PASSWORD_ALLOW_BASE.length());
            char rndChar = PASSWORD_ALLOW_BASE.charAt(rndCharAt);

            sb.append(rndChar);
        }
        return sb.toString();
    }
}
