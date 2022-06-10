package ru.flendger.school.puzzler.students.model.service.download;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.students.model.service.download.dto.StudentImportData;
import ru.flendger.school.puzzler.students.model.entity.SchoolClass;
import ru.flendger.school.puzzler.students.model.entity.Student;
import ru.flendger.school.puzzler.students.model.service.download.parser.StudentInputParser;
import ru.flendger.school.puzzler.students.model.dao.SchoolClassStorageService;
import ru.flendger.school.puzzler.students.model.dao.StudentStorageService;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentDownloadServiceImpl implements StudentDownloadService {
    private final StudentStorageService studentStorageService;
    private final SchoolClassStorageService schoolClassStorageService;
    private final StudentInputParser studentInputParser;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveStudents(InputStream inputStream) throws IOException, EntityNotFoundException {
        List<StudentImportData> importData = studentInputParser.parse(inputStream);

        importData.forEach(
                studentImportData -> {
                    String schoolClassName = studentImportData.getSchoolClassName();

                    SchoolClass schoolClass = schoolClassStorageService.findByName(schoolClassName)
                            .orElseThrow(() -> createSchoolClassNotFoundException(schoolClassName));

                    Student student = createStudent(studentImportData.getStudentName(), schoolClass);
                    studentStorageService.save(student);
                });
    }

    private Student createStudent(String studentName, SchoolClass schoolClass) {
        Student student = new Student();

        student.setName(studentName);
        student.setSchoolClass(schoolClass);

        return student;
    }

    private EntityNotFoundException createSchoolClassNotFoundException(String schoolClassName) {
        return new EntityNotFoundException(messageSchoolClassNotFound(schoolClassName));
    }

    private String messageSchoolClassNotFound(String schoolClassName) {
        return String.format("School class not found [%s]", schoolClassName);
    }
}
