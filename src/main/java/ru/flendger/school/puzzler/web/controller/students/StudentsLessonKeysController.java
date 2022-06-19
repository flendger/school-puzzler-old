package ru.flendger.school.puzzler.web.controller.students;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.school.puzzler.students.model.service.studentslessonkeys.StudentsLessonKeysService;
import ru.flendger.school.puzzler.students.model.service.studentslessonkeys.dto.StudentLessonKeyRowDto;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

@RestController
@RequestMapping("/api/v1/students/students-lesson-keys")
@RequiredArgsConstructor
@Slf4j
public class StudentsLessonKeysController {
    private final StudentsLessonKeysService studentsLessonKeysService;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(studentsLessonKeysService.getActive());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody StudentLessonKeyRowDto studentLessonKeyRowDto) {
        try {
            studentsLessonKeysService.delete(studentLessonKeyRowDto.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ResponseMessage.createResponse("Не удалось удалить урок студента", HttpStatus.BAD_REQUEST);
        }

        return ResponseMessage.createResponse("Урок студента удален", HttpStatus.OK);
    }
}
