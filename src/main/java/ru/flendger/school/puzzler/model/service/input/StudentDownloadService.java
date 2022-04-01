package ru.flendger.school.puzzler.model.service.input;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface StudentDownloadService {
    void saveStudents(InputStream inputStream) throws IOException, EntityNotFoundException;
}
