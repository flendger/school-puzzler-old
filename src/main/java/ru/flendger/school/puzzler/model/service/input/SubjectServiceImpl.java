package ru.flendger.school.puzzler.model.service.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.dto.SubjectDto;
import ru.flendger.school.puzzler.model.service.output.SubjectStorageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectStorageService subjectStorageService;
    private final ModelMapper modelMapper;

    @Override
    public List<SubjectDto> findAll() {
        return subjectStorageService
                .findAll()
                .stream()
                .map(subject -> modelMapper.map(subject, SubjectDto.class))
                .collect(Collectors.toList());
    }
}
