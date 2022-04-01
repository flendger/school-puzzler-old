package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.service.input.StudentLessonService;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class StudentLessonController {
    private final StudentLessonService studentLessonService;

    @GetMapping
    public ResponseEntity<?> getLessons() {
        return ResponseEntity.ok(studentLessonService.getLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLesson(@PathVariable("id") Long id) {
        Optional<LessonDto> lessonOptional = studentLessonService.getLesson(id);

        if (lessonOptional.isPresent()) {
            return ResponseEntity.ok(lessonOptional.get());
        } else {
            return ResponseMessage.createResponse("Lesson doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
}
