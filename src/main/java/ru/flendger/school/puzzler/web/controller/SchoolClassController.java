package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.model.dto.SchoolClassDto;
import ru.flendger.school.puzzler.model.manager.SchoolClassManager;
import ru.flendger.school.puzzler.web.message.ResponseMessage;

@RestController
@RequestMapping("/api/v1/admin/classes")
@RequiredArgsConstructor
public class SchoolClassController {
    private final SchoolClassManager schoolClassManager;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(schoolClassManager.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SchoolClassDto schoolClassDto) {
        try {
            schoolClassManager.save(schoolClassDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось сохранить школьный класс", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Школьный класс сохранен успешно", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody SchoolClassDto schoolClassDto) {
        try {
            schoolClassManager.delete(schoolClassDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось удалить школьный класс", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Школьный класс удален успешно", HttpStatus.OK);
    }
}
