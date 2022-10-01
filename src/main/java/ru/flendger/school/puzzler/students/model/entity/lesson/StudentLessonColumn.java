package ru.flendger.school.puzzler.students.model.entity.lesson;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StudentLessonColumn {
    private int orderNum;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentLessonColumn that = (StudentLessonColumn) o;

        if (orderNum != that.orderNum) return false;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int result = orderNum;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
