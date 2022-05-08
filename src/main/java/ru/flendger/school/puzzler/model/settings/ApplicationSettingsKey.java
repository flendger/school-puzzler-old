package ru.flendger.school.puzzler.model.settings;

import ru.flendger.school.puzzler.model.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.model.settings.props.AbstractApplicationSetting;
import ru.flendger.school.puzzler.model.settings.props.KeyExpiredTimeSetting;

import java.util.Arrays;

public enum ApplicationSettingsKey {
    KEY_EXPIRED_TIME(KeyExpiredTimeSetting.class);

    private final Class<? extends AppSetting<?>> keyType;

    ApplicationSettingsKey(Class<? extends AbstractApplicationSetting<?>> keyType) {
        this.keyType = keyType;
    }

    public Class<? extends AppSetting<?>> getKeyType() {
        return keyType;
    }

    public AppSetting<?> create() throws Exception {
        return this.keyType.getConstructor().newInstance();
    }

    public static ApplicationSettingsKey getKey(Class<? extends AppSetting<?>> keyType) {
        return Arrays
                .stream(ApplicationSettingsKey.values())
                .filter(key -> key.getKeyType().equals(keyType))
                .findFirst()
                .orElse(null);
    }

    public static AppSetting<?> fromEntity(ApplicationSettingEntity entity) throws Exception {
            ApplicationSettingsKey key = entity.getKey();

            AppSetting<?> applicationSetting = key.getKeyType().getConstructor().newInstance();
            applicationSetting.setStringValue(entity.getValue());

            return applicationSetting;
    }

    public static ApplicationSettingEntity toEntity(AppSetting<?> setting) {
        return ApplicationSettingEntity
                .builder()
                .key(setting.getKey())
                .value(setting.getStringValue())
                .build();
    }
}
