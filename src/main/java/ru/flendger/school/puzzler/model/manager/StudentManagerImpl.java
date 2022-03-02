package ru.flendger.school.puzzler.model.manager;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flendger.school.puzzler.model.dto.StudentDto;
import ru.flendger.school.puzzler.model.entity.Student;
import ru.flendger.school.puzzler.model.service.StudentService;

import javax.persistence.EntityNotFoundException;
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
}
