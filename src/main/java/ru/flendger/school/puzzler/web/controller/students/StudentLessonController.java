package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flendger.school.puzzler.students.model.service.lesson.StudentLessonService;
import ru.flendger.school.puzzler.students.model.service.lesson.dto.StudentLessonDto;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/students/lessons")
@RequiredArgsConstructor
@Slf4j
public class StudentLessonController {
    private final StudentLessonService studentLessonService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getLesson(@PathVariable("id") Long id) {
        try {
            StudentLessonDto lesson = studentLessonService.getLesson(id);

            return ResponseEntity.ok(lesson);
        } catch (EntityNotFoundException e) {
            return ResponseMessage.createResponse("Lesson doesn't exist", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.createResponse("Student lesson get error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
