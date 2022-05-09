package ru.flendger.school.puzzler.web.controller.studets;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
