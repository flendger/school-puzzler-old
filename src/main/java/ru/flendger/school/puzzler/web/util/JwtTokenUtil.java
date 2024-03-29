package ru.flendger.school.puzzler.web.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.web.model.entity.enums.RoleType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:secured.properties")
public class JwtTokenUtil {
    private static final String LESSON_KEY_CLAIM = "lessonKey";
    private static final String ROLES_CLAIM = "roles";

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserDetails userDetails, Long expiredTime, String lessonKey) {
        Map<String, Object> claims = new HashMap<>();
        List<String> rolesList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", rolesList);

        claims.put(LESSON_KEY_CLAIM, lessonKey);

        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + expiredTime);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public List<?> getRoles(String token) {
        return getClaimFromToken(token, claims -> claims.get(ROLES_CLAIM, List.class));
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isAdmin(UserDetails userDetails) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(grantedAuthority ->
                        Objects.equals(grantedAuthority.getAuthority(), RoleType.ROLE_ADMIN.toString()));
    }

    public String getLessonKey(String token) {
        return getClaimFromToken(token, claims -> claims.get(LESSON_KEY_CLAIM, String.class));
    }
}
