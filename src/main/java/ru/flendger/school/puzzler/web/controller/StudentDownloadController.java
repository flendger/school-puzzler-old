package ru.flendger.school.puzzler.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.flendger.school.puzzler.model.service.input.StudentDownloadService;
import ru.flendger.school.puzzler.web.dto.message.ResponseMessage;

import java.io.IOException;

@Controller
@RequestMapping("/api/v1/admin/students/download")
@RequiredArgsConstructor
public class StudentDownloadController {
    private final StudentDownloadService studentDownloadService;

    @PostMapping
    public ResponseEntity<?> download(@RequestParam("data") MultipartFile data) {
        try {
            studentDownloadService.saveStudents(data.getInputStream());
        } catch (IOException e) {
            ResponseMessage.createResponse("Не удалось загрузить данные по студентам из файла", HttpStatus.BAD_REQUEST);
        }

        return ResponseMessage.createResponse("Данные по студентам успешно загружены", HttpStatus.OK);
    }
}
