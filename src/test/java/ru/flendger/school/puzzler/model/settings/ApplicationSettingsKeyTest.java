package ru.flendger.school.puzzler.model.settings;

import org.junit.jupiter.api.Test;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.AppSetting;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;
import ru.flendger.school.puzzler.settings.KeyExpiredTimeSetting;

import static org.junit.jupiter.api.Assertions.*;
import static ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey.KEY_EXPIRED_TIME;

class ApplicationSettingsKeyTest {

    @Test
    void create() throws Exception {
        AppSetting<?> setting = KEY_EXPIRED_TIME.create();
        assertNotNull(setting.getValue());
        assertNotNull(setting.getStringValue());
    }

    @Test
    void fromEntity() throws Exception {
        ApplicationSettingEntity settingEntity = createApplicationSettingEntity("60");

        KeyExpiredTimeSetting setting = (KeyExpiredTimeSetting) ApplicationSettingsKey.fromEntity(settingEntity);

        assertEquals(settingEntity.getKey(), setting.getKey());
        assertEquals("60", setting.getStringValue());
        assertEquals(60, setting.getValue());
    }

    @Test
    void fromEntityNullValue() throws Exception {
        ApplicationSettingEntity settingEntity = createApplicationSettingEntity(null);

        KeyExpiredTimeSetting setting = (KeyExpiredTimeSetting) ApplicationSettingsKey.fromEntity(settingEntity);

        assertEquals(settingEntity.getKey(), setting.getKey());
        assertNull(setting.getStringValue());
        assertNull(setting.getValue());
    }

    @Test
    void toEntity() throws Exception {
        AppSetting<Integer> setting = createKeyExpAppSetting(60);

        ApplicationSettingEntity settingEntity = ApplicationSettingsKey.toEntity(setting);

        assertEquals(setting.getKey(), settingEntity.getKey());
        assertEquals("60", settingEntity.getValue());
    }

    @Test
    void toEntityNullValue() throws Exception {
        AppSetting<Integer> setting = createKeyExpAppSetting(null);

        ApplicationSettingEntity settingEntity = ApplicationSettingsKey.toEntity(setting);

        assertEquals(setting.getKey(), settingEntity.getKey());
        assertNull( settingEntity.getValue());
    }

    private ApplicationSettingEntity createApplicationSettingEntity(String value) {
        return ApplicationSettingEntity
                .builder()
                .key(KEY_EXPIRED_TIME)
                .value(value)
                .build();
    }

    private AppSetting<Integer> createKeyExpAppSetting(Integer value) throws Exception {
        AppSetting<Integer> setting = (KeyExpiredTimeSetting) KEY_EXPIRED_TIME.create();
        setting.setValue(value);
        return setting;
    }
}