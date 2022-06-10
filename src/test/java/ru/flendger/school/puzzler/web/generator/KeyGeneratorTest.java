package ru.flendger.school.puzzler.web.generator;

import org.junit.jupiter.api.Test;
import ru.flendger.school.puzzler.students.model.service.lessonkeys.generator.KeyGenerator;

import static org.junit.jupiter.api.Assertions.*;

class KeyGeneratorTest {
    private final KeyGenerator keyGenerator = new KeyGenerator();

    @Test
    void generate() {
        String keyValue = keyGenerator.generate();

        assertEquals(6, keyValue.length());
        assertTrue(keyValue.chars().allMatch(Character::isDigit));
    }
}