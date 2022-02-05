package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.model.dto.LessonDto;
import ru.flendger.school.puzzler.model.manager.StudentLessonManager;
import ru.flendger.school.puzzler.web.message.ResponseMessage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lesson")
@RequiredArgsConstructor
public class StudentLessonController {
    private final StudentLessonManager studentLessonManager;

    @GetMapping
    public ResponseEntity<?> getLessons() {
        return ResponseEntity.ok(studentLessonManager.getLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLesson(@PathVariable("id") Long id) {
        Optional<LessonDto> lessonOptional = studentLessonManager.getLesson(id);

        if (lessonOptional.isPresent()) {
            return ResponseEntity.ok(lessonOptional.get());
        } else {
            return ResponseMessage.createResponse("Lesson doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
}
