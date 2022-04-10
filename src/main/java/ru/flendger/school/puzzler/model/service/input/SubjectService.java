package ru.flendger.school.puzzler.model.service.input;

import ru.flendger.school.puzzler.model.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll();
}
