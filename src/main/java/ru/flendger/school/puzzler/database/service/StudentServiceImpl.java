package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.StudentRepository;
import ru.flendger.school.puzzler.model.entity.Student;
import ru.flendger.school.puzzler.model.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends AbstractCrudService<Student, Long, StudentRepository> implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    StudentRepository getRepository() {
        return studentRepository;
    }
}
