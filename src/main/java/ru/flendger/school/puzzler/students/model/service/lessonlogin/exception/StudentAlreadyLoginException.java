package ru.flendger.school.puzzler.students.model.service.lessonlogin.exception;

public class StudentAlreadyLoginException extends RuntimeException{
    public StudentAlreadyLoginException(String message) {
        super(message);
    }
}
