package ru.flendger.school.puzzler.web.generator;

import org.junit.jupiter.api.Test;

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