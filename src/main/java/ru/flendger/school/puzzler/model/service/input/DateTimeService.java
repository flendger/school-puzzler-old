package ru.flendger.school.puzzler.model.service.input;

import java.time.LocalDateTime;

public interface DateTimeService {
    LocalDateTime current();
    String toLocalFormat(LocalDateTime dateTime);
}
