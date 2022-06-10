package ru.flendger.school.puzzler.settings.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.dao.ApplicationSettingEntityStorageService;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationSettingsService {
    private final ApplicationSettingEntityStorageService settingEntityStorageService;

    private ConcurrentMap<Class<? extends AppSetting<?>>, AppSetting<?>> settings;

    public void read() {
        settings = Arrays
                .stream(ApplicationSettingsKey.values())
                .map(
                        key -> {
                            try {
                                Optional<ApplicationSettingEntity> settingEntityOptional = settingEntityStorageService.findById(key);
                                if (settingEntityOptional.isPresent()) {
                                    ApplicationSettingEntity settingEntity = settingEntityOptional.get();

                                    return ApplicationSettingsKey.fromEntity(settingEntity);
                                } else {
                                    AppSetting<?> setting = key.create();

                                    saveSetting(setting);

                                    return setting;
                                }
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                                return null;
                            }
                        })
                .filter(Objects::nonNull)
                .collect(Collectors.toConcurrentMap(appSetting -> appSetting.getKey().getKeyType(), Function.identity()));
    }

    private void saveSetting(AppSetting<?> setting) {
        ApplicationSettingEntity settingEntity = ApplicationSettingsKey.toEntity(setting);
        settingEntityStorageService.save(settingEntity);
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
        saveSetting(setting);

        settings.put(setting.getKey().getKeyType(), setting);
    }
}
