package ru.flendger.school.puzzler.model.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.flendger.school.puzzler.model.dto.StudentImportData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentInputParserTest {
    private StudentInputParser studentInputParser;
    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        studentInputParser = new StudentInputParser();

        String studentData = getStudentData();
        inputStream = new ByteArrayInputStream(studentData.getBytes(StandardCharsets.UTF_8));
    }

    private String getStudentData() {
        return "student1;class1\n" +
                "error;\n" +
                "student2;class1";
    }

    @Test
    void parse() throws IOException {
        List<StudentImportData> studentImportData = studentInputParser.parse(inputStream);
        assertEquals(2, studentImportData.size());

        StudentImportData studentImportData1 = studentImportData.get(0);
        assertEquals("student1", studentImportData1.getStudentName());
        assertEquals("class1", studentImportData1.getSchoolClassName());

        StudentImportData studentImportData2 = studentImportData.get(1);
        assertEquals("student2", studentImportData2.getStudentName());
        assertEquals("class1", studentImportData2.getSchoolClassName());
    }
}