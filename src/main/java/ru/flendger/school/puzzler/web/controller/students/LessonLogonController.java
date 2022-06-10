package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.students.model.service.lessonlogon.LessonLogonService;
import ru.flendger.school.puzzler.students.model.service.lessonlogon.dto.LessonLogonRequest;

@RestController
@RequestMapping("/api/v1/students/login")
@RequiredArgsConstructor
public class LessonLogonController {
    private final LessonLogonService lessonLogonService;

    @GetMapping("/{key}")
    public ResponseEntity<?> getStudents(@PathVariable("key") String keyValue) {
        return ResponseEntity.ok(lessonLogonService.findStudentsByLessonKey(keyValue));
    }

    @PostMapping
    public ResponseEntity<?> logon(@RequestBody LessonLogonRequest logonRequest) {
        return null;
    }
}
