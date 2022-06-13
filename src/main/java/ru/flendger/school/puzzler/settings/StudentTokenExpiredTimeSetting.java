package ru.flendger.school.puzzler.settings;

import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;
import ru.flendger.school.puzzler.settings.core.props.AbstractApplicationSetting;

import java.util.Objects;

public class StudentTokenExpiredTimeSetting extends AbstractApplicationSetting<Integer> {
    public StudentTokenExpiredTimeSetting() {
        super(ApplicationSettingsKey.STUDENT_TOKEN_EXPIRED_TIME);
    }

    @Override
    public Integer getDefaultValue() {
        return 60; //minutes
    }

    @Override
    protected Integer convertToValue(String stringValue) {
        return Objects.isNull(stringValue) ? null : Integer.valueOf(stringValue);
    }
}
