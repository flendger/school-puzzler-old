package ru.flendger.school.puzzler.web.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserSecurityToken extends UsernamePasswordAuthenticationToken {
    private final String lessonKey;

    public UserSecurityToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String lessonKey) {
        super(principal, credentials, authorities);
        this.lessonKey = lessonKey;
    }

    public String getLessonKey() {
        return lessonKey;
    }
}
