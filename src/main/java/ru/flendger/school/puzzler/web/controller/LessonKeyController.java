package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;
import ru.flendger.school.puzzler.web.service.input.LessonKeyService;

@RestController
@RequestMapping("/api/v1/admin/lkey")
@RequiredArgsConstructor
public class LessonKeyController {
    private final LessonKeyService lessonKeyService;

    @PostMapping
    public ResponseEntity<?> generate(@RequestBody LessonKeyRequest lessonKeyRequest) {
        try {
            return ResponseEntity.ok(lessonKeyService.generateKey(lessonKeyRequest));
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось сгенерировать ключ", HttpStatus.BAD_REQUEST);
        }
    }
}
