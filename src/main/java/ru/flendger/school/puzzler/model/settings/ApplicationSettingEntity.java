package ru.flendger.school.puzzler.model.settings;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "settings")
public class ApplicationSettingEntity {
    @Id
    @Column(name = "key")
    @Enumerated(EnumType.STRING)
    private ApplicationSettingsKey key;

    @Column(name = "value")
    private String value;
}
