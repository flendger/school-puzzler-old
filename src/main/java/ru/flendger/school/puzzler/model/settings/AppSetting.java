package ru.flendger.school.puzzler.model.settings;

public interface AppSetting<T> {
    ApplicationSettingsKey getKey();

    String getStringValue();

    T getValue();

    void setValue(T value);

    void setStringValue(String stringValue);
}
