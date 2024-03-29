package ru.flendger.school.puzzler.students.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.students.database.repository.StudentRepository;
import ru.flendger.school.puzzler.students.model.entity.Student;
import ru.flendger.school.puzzler.students.model.dao.StudentStorageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentStorageServiceImpl extends AbstractCrudService<Student, Long, StudentRepository> implements StudentStorageService {
    private final StudentRepository studentRepository;

    @Override
    protected StudentRepository getRepository() {
        return studentRepository;
    }

    @Override
    public List<Student> findBySchoolClass(String schoolClassName) {
        return studentRepository.findBySchoolClass_NameLike(schoolClassName + "%");
    }

    @Override
    public List<Student> findBySchoolClass(Long schoolClassId) {
        return studentRepository.findBySchoolClass_Id(schoolClassId);
    }
}
