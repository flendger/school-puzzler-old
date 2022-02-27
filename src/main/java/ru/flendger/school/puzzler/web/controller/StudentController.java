package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.model.dto.StudentDto;
import ru.flendger.school.puzzler.model.manager.StudentManager;
import ru.flendger.school.puzzler.web.message.ResponseMessage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentManager studentManager;

    @GetMapping
    public ResponseEntity<?> findBySchoolClass(@RequestParam("classId") Long classId) {
        return ResponseEntity.ok(studentManager.findBySchoolClass(classId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Optional<StudentDto> studentDtoOptional = studentManager.findById(id);
        if (studentDtoOptional.isPresent()) {
            return ResponseEntity.ok(studentDtoOptional.get());
        } else {
            return ResponseMessage.createResponse("Студент не найден", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/new")
    public ResponseEntity<?> getNew() {
        return ResponseEntity.ok(studentManager.create());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) {
        try {
            studentManager.save(studentDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось сохранить студента", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Студент сохранен успешно", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody StudentDto studentDto) {
        try {
            studentManager.delete(studentDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось удалить студента", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Студент удален успешно", HttpStatus.OK);
    }
}
