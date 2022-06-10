package ru.flendger.school.puzzler.settings.core.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.common.AbstractCrudService;
import ru.flendger.school.puzzler.settings.core.database.repository.ApplicationSettingRepository;
import ru.flendger.school.puzzler.settings.core.dao.ApplicationSettingEntityStorageService;
import ru.flendger.school.puzzler.settings.core.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.settings.core.ApplicationSettingsKey;

@Service
@RequiredArgsConstructor
public class ApplicationSettingEntityStorageServiceImpl extends AbstractCrudService<ApplicationSettingEntity, ApplicationSettingsKey, ApplicationSettingRepository> implements ApplicationSettingEntityStorageService {
    private final ApplicationSettingRepository applicationSettingRepository;

    @Override
    protected ApplicationSettingRepository getRepository() {
        return applicationSettingRepository;
    }
}
