package ru.flendger.school.puzzler.settings;

import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;
import ru.flendger.school.puzzler.settings.core.props.AbstractApplicationSetting;

import java.util.Objects;

public class StudentLessonKeyBeforeTimeSetting extends AbstractApplicationSetting<Integer> {
    public StudentLessonKeyBeforeTimeSetting() {
        super(ApplicationSettingsKey.KEY_EXPIRED_TIME);
    }

    @Override
    public Integer getDefaultValue() {
        return 3; //hours
    }

    @Override
    protected Integer convertToValue(String stringValue) {
        return Objects.isNull(stringValue) ? null : Integer.valueOf(stringValue);
    }
}
