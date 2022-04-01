package ru.flendger.school.puzzler.model.parser;

import org.springframework.stereotype.Component;
import ru.flendger.school.puzzler.model.dto.StudentImportData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentInputParser {
    public List<StudentImportData> parse(InputStream inputStream) throws IOException {
        List<StudentImportData> studentsData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitStrings = line.split(";");

                if (splitStrings.length < 2) {
                    continue;
                }

                String studentName = splitStrings[0].trim();
                if (studentName.isEmpty()) {
                    continue;
                }

                String schoolClassName = splitStrings[1].trim();
                if (schoolClassName.isEmpty()) {
                    continue;
                }

                StudentImportData studentImportData = new StudentImportData(studentName, schoolClassName);
                studentsData.add(studentImportData);
            }
        }

        return studentsData;
    }
}
