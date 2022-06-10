package ru.flendger.school.puzzler.settings.core.dao;

import ru.flendger.school.puzzler.common.CrudStorageService;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

public interface ApplicationSettingEntityStorageService extends CrudStorageService<ApplicationSettingEntity, ApplicationSettingsKey> {
}
