package ru.flendger.school.puzzler.settings;

import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;
import ru.flendger.school.puzzler.settings.core.props.AbstractApplicationSetting;

import java.util.Objects;

public class KeyExpiredTimeSetting extends AbstractApplicationSetting<Integer> {
    public KeyExpiredTimeSetting() {
        super(ApplicationSettingsKey.KEY_EXPIRED_TIME);
    }

    @Override
    public Integer getDefaultValue() {
        return 45 * 60;
    }

    @Override
    protected Integer convertToValue(String stringValue) {
        return Objects.isNull(stringValue) ? null : Integer.valueOf(stringValue);
    }
}
