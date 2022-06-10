package ru.flendger.school.puzzler.model.service.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.flendger.school.puzzler.datetime.DateTimeService;
import ru.flendger.school.puzzler.datetime.DateTimeServiceImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeServiceImplTest {
    private DateTimeService dateTimeService;

    @BeforeEach
    void setUp() {
        dateTimeService = new DateTimeServiceImpl();
    }

    @Test
    void toLocalFormat() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 5, 8, 23, 50, 51);

        String localFormat = dateTimeService.toLocalFormat(dateTime);
        assertEquals("08.05.2022 23:50:51", localFormat);
    }
}