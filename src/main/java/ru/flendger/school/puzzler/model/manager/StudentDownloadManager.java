package ru.flendger.school.puzzler.model.manager;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface StudentDownloadManager {
    void saveStudents(InputStream inputStream) throws IOException, EntityNotFoundException;
}
