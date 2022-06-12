package ru.flendger.school.puzzler.web.controller.lessons;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.lessons.model.service.subject.SubjectService;

@RestController
@RequestMapping("/api/v1/lessons/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(subjectService.findAll());
    }
}
