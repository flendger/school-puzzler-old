package ru.flendger.school.puzzler.lessons.model.service.subject;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.lessons.model.service.subject.dto.SubjectDto;
import ru.flendger.school.puzzler.lessons.model.dao.SubjectStorageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectStorageService subjectStorageService;
    private final ModelMapper lessonsModelMapper;

    @Override
    public List<SubjectDto> findAll() {
        return subjectStorageService
                .findAll()
                .stream()
                .map(subject -> lessonsModelMapper.map(subject, SubjectDto.class))
                .collect(Collectors.toList());
    }
}
