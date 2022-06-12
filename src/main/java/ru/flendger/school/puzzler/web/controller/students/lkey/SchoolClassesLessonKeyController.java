package ru.flendger.school.puzzler.web.controller.students.lkey;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.students.model.service.schoolclass.SchoolClassService;

@RestController
@RequestMapping("/api/v1/students/lkey/classes")
@RequiredArgsConstructor
public class SchoolClassesLessonKeyController {
    private final SchoolClassService schoolClassService;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(schoolClassService.findAll());
    }
}
