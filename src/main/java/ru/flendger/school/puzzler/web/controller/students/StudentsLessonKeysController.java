package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.students.model.service.studentslessonkeys.StudentsLessonKeysService;

@RestController
@RequestMapping("/api/v1/students/students-lesson-keys")
@RequiredArgsConstructor
public class StudentsLessonKeysController {
    private final StudentsLessonKeysService studentsLessonKeysService;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(studentsLessonKeysService.getActive());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long studentLessonKeyId) {
        return ResponseEntity.ok(studentLessonKeyId);
    }
}
