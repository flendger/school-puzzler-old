package ru.flendger.school.puzzler.settings.core.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

public interface ApplicationSettingRepository extends JpaRepository<ApplicationSettingEntity, ApplicationSettingsKey> {
}
