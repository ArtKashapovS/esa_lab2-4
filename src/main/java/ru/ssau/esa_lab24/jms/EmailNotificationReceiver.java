package ru.ssau.esa_lab24.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.ssau.esa_lab24.jms.dto.EntityChangeRecord;
import ru.ssau.esa_lab24.models.EntityChangeLog;
import ru.ssau.esa_lab24.services.EmailSenderService;

import java.time.LocalDate;

@Component
public class EmailNotificationReceiver {

    private EmailSenderService emailSenderService;

    public EmailNotificationReceiver(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @JmsListener(destination = "entityChange")
    public void receiveMessage(EntityChangeRecord entityChangeRecord) {
        EntityChangeLog entityChangeLog = new EntityChangeLog();
        entityChangeLog.setEntityId(entityChangeRecord.getEntityId());
        entityChangeLog.setChangeDate(LocalDate.now());
        entityChangeLog.setChangeType(entityChangeRecord.getChangeType());
        emailSenderService.sendSimpleEmail("ar.spamovich@gmail.com", "entityChange", entityChangeLog.toString());
    }
}
