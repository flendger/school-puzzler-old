package ru.flendger.school.puzzler.web.controller.students.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.students.model.service.lessonlogin.LessonLoginService;

@RestController
@RequestMapping("/api/v1/students/login/classes")
@RequiredArgsConstructor
public class SchoolClassesLoginController {
    private final LessonLoginService lessonLoginService;

    @GetMapping("/{key}")
    public ResponseEntity<?> getStudents(@PathVariable("key") String keyValue) {
        return ResponseEntity.ok(lessonLoginService.findStudentsByLessonKey(keyValue));
    }
}
