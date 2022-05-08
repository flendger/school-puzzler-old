package ru.flendger.school.puzzler.model.settings.props;

import ru.flendger.school.puzzler.model.settings.ApplicationSettingsKey;

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
