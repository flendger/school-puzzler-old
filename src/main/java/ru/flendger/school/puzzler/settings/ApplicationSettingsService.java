package ru.flendger.school.puzzler.settings;

import ru.flendger.school.puzzler.settings.core.AppSetting;

public interface ApplicationSettingsService {
    void read();

    <T extends AppSetting<?>> T getSetting(Class<T> keyType);

    void setSetting(AppSetting<?> setting);
}
