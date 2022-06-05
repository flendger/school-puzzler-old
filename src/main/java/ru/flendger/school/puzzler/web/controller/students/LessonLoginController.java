package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.model.service.input.LessonLoginService;

@RestController
@RequestMapping("/api/v1/students/login")
@RequiredArgsConstructor
public class LessonLoginController {
    private final LessonLoginService lessonLoginService;

    @GetMapping("/{key}")
    public ResponseEntity<?> getStudents(@PathVariable("key") String keyValue) {
        return ResponseEntity.ok(lessonLoginService.findByLessonKey(keyValue));
    }

    @PostMapping
    public ResponseEntity<?> logon(@RequestBody String l) { // TODO: 20.05.2022 dto
        return null;
    }
}
