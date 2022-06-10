package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.students.model.service.student.dto.StudentDto;
import ru.flendger.school.puzzler.students.model.service.student.StudentService;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> findBySchoolClass(@RequestParam("className") String className) {
        return ResponseEntity.ok(studentService.findBySchoolClass(className));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Optional<StudentDto> studentDtoOptional = studentService.findById(id);
        if (studentDtoOptional.isPresent()) {
            return ResponseEntity.ok(studentDtoOptional.get());
        } else {
            return ResponseMessage.createResponse("Студент не найден", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/new")
    public ResponseEntity<?> getNew() {
        return ResponseEntity.ok(studentService.create());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) {
        try {
            studentService.save(studentDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось сохранить студента", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Студент сохранен успешно", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody StudentDto studentDto) {
        try {
            studentService.delete(studentDto);
        } catch (Exception e) {
            return ResponseMessage.createResponse("Не удалось удалить студента", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseMessage.createResponse("Студент удален успешно", HttpStatus.OK);
    }
}
