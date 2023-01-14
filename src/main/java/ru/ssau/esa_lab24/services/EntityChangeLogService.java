package ru.ssau.esa_lab24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.esa_lab24.models.EntityChangeLog;
import ru.ssau.esa_lab24.repositories.EntityChangeLogRepository;

@Service
public class EntityChangeLogService {
    private final EntityChangeLogRepository entityChangeLogRepository;

    @Autowired
    public EntityChangeLogService(EntityChangeLogRepository entityChangeLogRepository) {
        this.entityChangeLogRepository = entityChangeLogRepository;
    }

    public void save(EntityChangeLog entityChangeLog) {
        entityChangeLogRepository.save(entityChangeLog);
    }
}
