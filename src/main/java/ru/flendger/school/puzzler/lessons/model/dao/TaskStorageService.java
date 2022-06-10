package ru.flendger.school.puzzler.lessons.model.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.lessons.model.entity.Task;

public interface TaskStorageService extends CrudStorageService<Task, Long> {
}
