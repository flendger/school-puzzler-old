package ru.flendger.school.puzzler.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flendger.school.puzzler.model.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.model.settings.ApplicationSettingsKey;

public interface ApplicationSettingRepository extends JpaRepository<ApplicationSettingEntity, ApplicationSettingsKey> {
}
