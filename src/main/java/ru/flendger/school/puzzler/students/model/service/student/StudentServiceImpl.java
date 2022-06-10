package ru.flendger.school.puzzler.students.model.service.student;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.students.model.service.student.dto.StudentDto;
import ru.flendger.school.puzzler.students.model.entity.Student;
import ru.flendger.school.puzzler.students.model.dao.StudentStorageService;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentStorageService studentStorageService;
    private final ModelMapper studentsModelMapper;

    @Override
    public List<StudentDto> findAll() {
        return convertToDto(studentStorageService.findAll());
    }

    @Override
    public List<StudentDto> findBySchoolClass(String schoolClassName) {
        return convertToDto(studentStorageService.findBySchoolClass(schoolClassName));
    }

    private List<StudentDto> convertToDto(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(student -> studentsModelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        return studentStorageService.findById(id).map(student -> studentsModelMapper.map(student, StudentDto.class));
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
            student = studentStorageService.findById(studentDto.getId())
                    .orElseThrow(() -> createEntityNotFoundException(studentDto));

            student.setSchoolClass(null);
            studentsModelMapper.map(studentDto, student);
        } else {
            student = studentsModelMapper.map(studentDto, Student.class);
        }

        studentStorageService.save(student);
    }

    private EntityNotFoundException createEntityNotFoundException(StudentDto studentDto) {
        return new EntityNotFoundException(messageStudentNotFound(studentDto));
    }

    private String messageStudentNotFound(StudentDto studentDto) {
        return String.format("Student not found ID [%d]", studentDto.getId());
    }

    @Override
    public void delete(StudentDto studentDto) {
        studentStorageService.delete(studentsModelMapper.map(studentDto, Student.class));
    }
}
