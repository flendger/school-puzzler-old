package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.students.model.service.schoolclass.dto.SchoolClassDto;
import ru.flendger.school.puzzler.students.model.service.schoolclass.SchoolClassService;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/classes")
@RequiredArgsConstructor
public class SchoolClassController {
    private final SchoolClassService schoolClassService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(schoolClassService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id) {
        Optional<SchoolClassDto> classDtoOptional = schoolClassService.findById(id);
        if (classDtoOptional.isPresent()) {
            return ResponseEntity.ok(classDtoOptional.get());
        } else {
            return ResponseMessage.createResponse("Школьный класс не найден", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/new")
    public ResponseEntity<?> getNew() {
        return ResponseEntity.ok(schoolClassService.create());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SchoolClassDto schoolClassDto) {
        try {
            schoolClassService.save(schoolClassDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось сохранить школьный класс", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Школьный класс сохранен успешно", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody SchoolClassDto schoolClassDto) {
        try {
            schoolClassService.delete(schoolClassDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось удалить школьный класс", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Школьный класс удален успешно", HttpStatus.OK);
    }
}
