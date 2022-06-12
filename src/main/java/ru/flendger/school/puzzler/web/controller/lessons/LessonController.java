package ru.flendger.school.puzzler.web.controller.lessons;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.lessons.model.service.lesson.LessonService;

@RestController
@RequestMapping("/api/v1/lessons/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<?> find(@RequestParam(value = "subjectId") Long subjectId) {
        return ResponseEntity.ok(lessonService.findBySubject(subjectId));
    }
}
