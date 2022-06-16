package ru.flendger.school.puzzler.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.flendger.school.puzzler.web.model.entity.enums.RoleType;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/admin/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/lessons/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/students/classes/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/students/students/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/students/students-lesson-keys/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/students/lkey/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .antMatchers("/api/v1/students/login/**").permitAll()
                .antMatchers("/api/v1/students/**").authenticated()
                .antMatchers("/api/v1/login/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(RoleType.ROLE_ADMIN.simpleName())
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
