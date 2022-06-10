package ru.flendger.school.puzzler.settings.core.props;

import ru.flendger.school.puzzler.settings.core.AppSetting;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

import java.util.Objects;

public abstract class AbstractApplicationSetting<T> implements AppSetting<T> {
    protected ApplicationSettingsKey key;
    protected String stringValue;
    protected T value;

    protected AbstractApplicationSetting(ApplicationSettingsKey key) {
        this.key = key;
        this.value = getDefaultValue();
        setValue(this.value);
    }

    protected abstract T convertToValue(String stringValue);

    public ApplicationSettingsKey getKey() {
        return key;
    }

    public String getStringValue() {
        return stringValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;

        if (Objects.nonNull(value)) {
            this.stringValue = value.toString();
        } else {
            this.stringValue = null;
        }
    }

    public void setStringValue(String stringValue) throws ClassCastException {
        this.stringValue = stringValue;
        this.value = convertToValue(stringValue);
    }
}
