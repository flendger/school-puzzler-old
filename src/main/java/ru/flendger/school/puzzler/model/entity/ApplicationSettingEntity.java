package ru.flendger.school.puzzler.model.entity;

import lombok.*;
import ru.flendger.school.puzzler.model.settings.ApplicationSettingsKey;

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
