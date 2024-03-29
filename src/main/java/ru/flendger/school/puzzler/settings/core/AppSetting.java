package ru.flendger.school.puzzler.settings.core;

public interface AppSetting<T> {
    ApplicationSettingsKey getKey();

    String getStringValue();

    T getValue();

    void setValue(T value);

    void setStringValue(String stringValue);

    T getDefaultValue();
}
