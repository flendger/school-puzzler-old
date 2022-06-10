package ru.flendger.school.puzzler.datetime;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public LocalDateTime current() {
        return LocalDateTime.now();
    }

    @Override
    public String toLocalFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
