package ru.flendger.school.puzzler.database.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.flendger.school.puzzler.settings.core.database.repository.ApplicationSettingRepository;
import ru.flendger.school.puzzler.settings.core.AppSetting;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("off-liquibase")
class ApplicationSettingRepositoryTest {
    @Autowired
    private ApplicationSettingRepository repository;

    @Test
    public void saveAndUpdateSettingsTest() throws Exception {
        AppSetting<?> appSetting = ApplicationSettingsKey.KEY_EXPIRED_TIME.create();
        appSetting.setStringValue("5");

        ApplicationSettingEntity applicationSettingEntity = ApplicationSettingsKey.toEntity(appSetting);
        repository.saveAndFlush(applicationSettingEntity);

        appSetting.setStringValue("6");
        ApplicationSettingEntity updatedSetting = ApplicationSettingsKey.toEntity(appSetting);
        repository.saveAndFlush(updatedSetting);

        assertEquals("6", repository.findAll().get(0).getValue());
    }
}