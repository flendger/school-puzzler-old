package ru.flendger.school.puzzler.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.school.puzzler.database.repositories.ApplicationSettingRepository;
import ru.flendger.school.puzzler.model.service.output.ApplicationSettingEntityStorageService;
import ru.flendger.school.puzzler.model.entity.ApplicationSettingEntity;
import ru.flendger.school.puzzler.model.settings.ApplicationSettingsKey;

@Service
@RequiredArgsConstructor
public class ApplicationSettingEntityStorageServiceImpl extends AbstractCrudService<ApplicationSettingEntity, ApplicationSettingsKey, ApplicationSettingRepository> implements ApplicationSettingEntityStorageService {
    private final ApplicationSettingRepository applicationSettingRepository;

    @Override
    protected ApplicationSettingRepository getRepository() {
        return applicationSettingRepository;
    }
}
