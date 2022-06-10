package ru.flendger.school.puzzler.settings.core.entity;

import lombok.*;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "settings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationSettingEntity {
    @Id
    @Column(name = "key")
    @Enumerated(EnumType.STRING)
    private ApplicationSettingsKey key;

    @Column(name = "value")
    private String value;
}
