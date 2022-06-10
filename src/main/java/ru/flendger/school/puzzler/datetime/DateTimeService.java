package ru.flendger.school.puzzler.datetime;

import java.time.LocalDateTime;

public interface DateTimeService {
    LocalDateTime current();
    String toLocalFormat(LocalDateTime dateTime);
}
