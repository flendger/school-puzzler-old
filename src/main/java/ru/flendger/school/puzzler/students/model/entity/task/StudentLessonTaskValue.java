package ru.flendger.school.puzzler.students.model.entity.task;

import lombok.Getter;
import lombok.Setter;
import ru.flendger.school.puzzler.lessons.model.enums.TaskValueType;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentLessonTaskValue that = (StudentLessonTaskValue) o;

        if (orderNum != that.orderNum) return false;
        if (accessible != that.accessible) return false;
        if (valueType != that.valueType) return false;
        if (!Objects.equals(value1, that.value1)) return false;
        if (!Objects.equals(value2, that.value2)) return false;
        return Objects.equals(value3, that.value3);
    }

    @Override
    public int hashCode() {
        int result = valueType != null ? valueType.hashCode() : 0;
        result = 31 * result + orderNum;
        result = 31 * result + (value1 != null ? value1.hashCode() : 0);
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        result = 31 * result + (value3 != null ? value3.hashCode() : 0);
        result = 31 * result + (accessible ? 1 : 0);
        return result;
    }
}
