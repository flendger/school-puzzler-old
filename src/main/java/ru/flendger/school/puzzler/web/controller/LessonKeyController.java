package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.web.dto.LessonKeyRequest;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;
import ru.flendger.school.puzzler.web.service.input.LessonKeyService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/admin/lkey")
@RequiredArgsConstructor
@Slf4j
public class LessonKeyController {
    private final LessonKeyService lessonKeyService;

    @PostMapping
    public ResponseEntity<?> generate(@RequestBody LessonKeyRequest lessonKeyRequest) {
        try {
            return ResponseEntity.ok(lessonKeyService.generateKey(lessonKeyRequest));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.createResponse("Не удалось сгенерировать ключ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable String key){
        try {
            lessonKeyService.delete(key);
            return ResponseMessage.createResponse(String.format("Ключ %s успешно удален", key), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseMessage.createResponse(String.format("Ключ %s не существует либо не активен", key), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
           return ResponseMessage.createResponse(String.format("Не удалось удалить ключ %s", key), HttpStatus.BAD_REQUEST);
        }
    }
}
// TODO: 09.04.2022 add generate key form to frontend

// TODO: 09.04.2022 get available by key students request

// TODO: 09.04.2022 enter lesson request (???)