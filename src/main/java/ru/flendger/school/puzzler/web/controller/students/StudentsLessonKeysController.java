package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students/students-lesson-keys")
@RequiredArgsConstructor
public class StudentsLessonKeysController {
    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok("list");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long studentLessonKeyId) {
        return ResponseEntity.ok(studentLessonKeyId);
    }
}
