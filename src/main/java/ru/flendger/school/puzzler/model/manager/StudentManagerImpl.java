package ru.flendger.school.puzzler.model.manager;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.dto.StudentDto;
import ru.flendger.school.puzzler.model.dto.StudentImportData;
import ru.flendger.school.puzzler.model.entity.SchoolClass;
import ru.flendger.school.puzzler.model.entity.Student;
import ru.flendger.school.puzzler.model.service.SchoolClassService;
import ru.flendger.school.puzzler.model.service.StudentInputParser;
import ru.flendger.school.puzzler.model.service.StudentService;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentManagerImpl implements StudentManager {
    private final StudentService studentService;
    private final ModelMapper modelMapper;
    private final SchoolClassService schoolClassService;
    private final StudentInputParser studentInputParser;

    @Override
    public List<StudentDto> findALl() {
        return convertToDto(studentService.findAll());
    }

    @Override
    public List<StudentDto> findBySchoolClass(String schoolClassName) {
        return convertToDto(studentService.findBySchoolClass(schoolClassName));
    }

    private List<StudentDto> convertToDto(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        return studentService.findById(id).map(student -> modelMapper.map(student, StudentDto.class));
    }

    @Override
    public StudentDto create() {
        return new StudentDto();
    }

    @Override
    @Transactional
    public void save(StudentDto studentDto) {
        Student student;

        if (Objects.nonNull(studentDto.getId())) {
            student = studentService.findById(studentDto.getId())
                    .orElseThrow(() -> createEntityNotFoundException(studentDto));

            student.setSchoolClass(null);
            modelMapper.map(studentDto, student);
        } else {
            student = modelMapper.map(studentDto, Student.class);
        }

        studentService.save(student);
    }

    private EntityNotFoundException createEntityNotFoundException(StudentDto studentDto) {
        return new EntityNotFoundException(messageStudentNotFound(studentDto));
    }

    private String messageStudentNotFound(StudentDto studentDto) {
        return String.format("Student not found ID [%d]", studentDto.getId());
    }

    @Override
    public void delete(StudentDto studentDto) {
        studentService.delete(modelMapper.map(studentDto, Student.class));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveStudents(InputStream inputStream) throws IOException, EntityNotFoundException {
        List<StudentImportData> importData = studentInputParser.parse(inputStream);

        importData.forEach(
                studentImportData -> {
                    String schoolClassName = studentImportData.getSchoolClassName();

                    SchoolClass schoolClass = schoolClassService.findByName(schoolClassName)
                            .orElseThrow(() -> createSchoolClassNotFoundException(schoolClassName));

                    Student student = createStudent(studentImportData.getStudentName(), schoolClass);
                    studentService.save(student);
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
