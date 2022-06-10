package ru.flendger.school.puzzler.lessons.model.service.subject;

import ru.flendger.school.puzzler.lessons.model.service.subject.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll();
}
