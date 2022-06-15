package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.students.model.service.lessonlogout.LessonLogoutService;
import ru.flendger.school.puzzler.web.config.UserSecurityToken;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/students/logout")
@RequiredArgsConstructor
@Slf4j
public class StudentLogoutController {
    private final LessonLogoutService lessonLogoutService;

    @PostMapping
    public ResponseEntity<?> logout(UserSecurityToken userSecurityToken) {
        if (Objects.isNull(userSecurityToken)) {
            return ResponseMessage.createResponse("Студент не авторизован", HttpStatus.BAD_REQUEST);
        }

        try {
            lessonLogoutService.logout(Long.parseLong(userSecurityToken.getName()), userSecurityToken.getLessonKey());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseMessage.createResponse("Не удалось выйти из урока", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().build();
    }
}
