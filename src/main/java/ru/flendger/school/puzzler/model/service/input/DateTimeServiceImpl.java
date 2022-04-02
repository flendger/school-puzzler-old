package ru.flendger.school.puzzler.model.service.input;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime current() {
        return LocalDateTime.now();
    }
}
