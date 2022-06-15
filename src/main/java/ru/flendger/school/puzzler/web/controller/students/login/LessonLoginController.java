package ru.flendger.school.puzzler.web.controller.students.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.LessonLoginService;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.dto.LessonLoginRequest;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.KeyNotFoundException;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.exception.StudentAlreadyLoginException;
import ru.flendger.school.puzzler.web.config.UserAuthenticationManager;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/students/login")
@RequiredArgsConstructor
@Slf4j
public class LessonLoginController {
    private final LessonLoginService lessonLoginService;
    private final UserAuthenticationManager userAuthenticationManager;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LessonLoginRequest loginRequest) {
        try {
            lessonLoginService.login(loginRequest);
        } catch (KeyNotFoundException e) {
            log.error(e.getMessage());
            return ResponseMessage.createResponse("Ключ не существует или срок действия истек", HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            return ResponseMessage.createResponse("Студент не найден", HttpStatus.BAD_REQUEST);
        } catch (StudentAlreadyLoginException e) {
            log.error(e.getMessage());
            return ResponseMessage.createResponse("Студент уже вошел в урок", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(userAuthenticationManager.authenticate(loginRequest.getStudentId(), loginRequest.getKeyValue()));
    }
}
