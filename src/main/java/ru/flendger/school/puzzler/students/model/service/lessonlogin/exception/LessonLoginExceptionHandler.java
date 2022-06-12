package ru.flendger.school.puzzler.students.model.service.lessonlogin.exception;

import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class LessonLoginExceptionHandler {
    public KeyNotFoundException keyNotValid(String keyValue) {
        return new KeyNotFoundException(messageKeyNotValid(keyValue));
    }

    private String messageKeyNotValid(String keyValue) {
        return String.format("Lesson key not found or expired: %s", keyValue);
    }

    public EntityNotFoundException studentNotFound(Long studentId) {
        return new EntityNotFoundException(messageStudentNotFound(studentId));
    }

    private String messageStudentNotFound(Long studentId) {
        return String.format("Student not found: %d", studentId);
    }

    public StudentAlreadyLoginException studentAlreadyLogin(String keyValue, Long studentId) {
        return new StudentAlreadyLoginException(messageStudentLogin(keyValue, studentId));
    }

    private String messageStudentLogin(String keyValue, Long studentId) {
        return String.format("Student already logged in: key[%s] id[%d] ", keyValue, studentId);
    }
}
