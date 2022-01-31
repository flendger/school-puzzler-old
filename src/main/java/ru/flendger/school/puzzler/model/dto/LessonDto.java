package ru.flendger.school.puzzler.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.model.entity.BaseEntity;
import ru.flendger.school.puzzler.model.entity.Subject;
import ru.flendger.school.puzzler.model.entity.Task;
import ru.flendger.school.puzzler.model.entity.TaskStructure;

import java.util.List;

@Getter
@Setter
public class LessonDto {
    private Long id;
    private String name;
    private String title;
//    private TaskStructure taskStructure;
//    private List<Task> tasks;
}
