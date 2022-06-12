package ru.flendger.school.puzzler.settings;

import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;
import ru.flendger.school.puzzler.settings.core.props.AbstractApplicationSetting;

import java.util.Objects;

public class AdminTokenExpiredTimeSetting extends AbstractApplicationSetting<Integer> {
    public AdminTokenExpiredTimeSetting() {
        super(ApplicationSettingsKey.ADMIN_TOKEN_EXPIRED_TIME);
    }

    @Override
    public Integer getDefaultValue() {
        return 30 * 24 * 60 * 60; //minutes
    }

    @Override
    protected Integer convertToValue(String stringValue) {
        return Objects.isNull(stringValue) ? null : Integer.valueOf(stringValue);
    }
}
