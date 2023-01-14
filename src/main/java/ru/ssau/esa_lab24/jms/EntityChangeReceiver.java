package ru.ssau.esa_lab24.jms;

import org.springframework.jms.annotation.JmsListener;
import ru.ssau.esa_lab24.jms.dto.EntityChangeRecord;
import ru.ssau.esa_lab24.models.EntityChangeLog;
import ru.ssau.esa_lab24.services.EntityChangeLogService;

import java.time.LocalDate;

public class EntityChangeReceiver {
    private EntityChangeLogService entityChangeLogService;

    public EntityChangeReceiver(EntityChangeLogService entityChangeLogService) {
        this.entityChangeLogService = entityChangeLogService;
    }

    @JmsListener(destination = "entityChange")
    public void receiveMessage(EntityChangeRecord entityChangeRecord) {
        EntityChangeLog entityChangeLog = new EntityChangeLog();
        entityChangeLog.setEntityId(entityChangeRecord.getEntityId());
        entityChangeLog.setChangeDate(LocalDate.now());
        entityChangeLog.setChangeType(entityChangeRecord.getChangeType());
        entityChangeLogService.save(entityChangeLog);
    }
}
