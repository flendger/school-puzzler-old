package ru.flendger.school.puzzler.students.model.entity.task;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.lessons.model.enums.TaskValueType;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Embeddable
public class StudentLessonTaskValue {
    @Enumerated(value = EnumType.STRING)
    private TaskValueType valueType;

    private int orderNum;

    private String value1;

    private String value2;

    private String value3;

    private boolean accessible;
}
