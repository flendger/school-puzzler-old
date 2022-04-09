package ru.flendger.school.puzzler.model.settings.props;

import ru.flendger.school.puzzler.model.settings.ApplicationSettingsKey;

public class KeyExpiredTimeSetting extends AbstractApplicationSetting<Integer> {
    public KeyExpiredTimeSetting() {
        super(ApplicationSettingsKey.KEY_EXPIRED_TIME);
    }
}
