package ru.flendger.school.puzzler.model.settings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.model.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.model.service.output.ApplicationSettingEntityStorageService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationSettingsService {
    private final ApplicationSettingEntityStorageService settingEntityStorageService;

    private ConcurrentMap<Class<? extends AppSetting<?>>, AppSetting<?>> settings;

    public void read() {
        List<ApplicationSettingEntity> settingEntities = settingEntityStorageService.findAll();

        settings = settingEntities
                .stream()
                .map(ApplicationSettingsKey::fromEntity)
                .filter(Objects::nonNull)
                .collect(Collectors.toConcurrentMap(appSetting -> appSetting.getKey().getKeyType(), Function.identity()));
    }

    public <T extends AppSetting<?>> T getSetting(Class<T> keyType) {
        if (Objects.isNull(settings)) {
            read();
        }

        AppSetting<?> appSetting = settings.get(keyType);
        if (Objects.nonNull(appSetting)) {
            return keyType.cast(appSetting);
        } else {
            ApplicationSettingsKey.getKey(keyType);
            return null;
        }
    }

    public void setSetting(AppSetting<?> setting) {
        ApplicationSettingEntity settingEntity = ApplicationSettingsKey.toEntity(setting);

        settingEntityStorageService.save(settingEntity);

        settings.put(setting.getKey().getKeyType(), setting);
    }
}
