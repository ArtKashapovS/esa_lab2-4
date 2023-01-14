package ru.ssau.esa_lab24.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.ssau.esa_lab24.enums.ChangeType;
import ru.ssau.esa_lab24.jms.dto.EntityChangeRecord;
import ru.ssau.esa_lab24.models.BaseEntity;

import javax.jms.JMSException;
import javax.jms.Topic;
import java.util.Arrays;

@Aspect
@Component
public class EntitySaveAspect {
    private JmsTemplate jmsTemplate;

    private Topic topic;

    @Autowired
    public EntitySaveAspect(JmsTemplate jmsTemplate) throws JMSException {
        this.jmsTemplate = jmsTemplate;
        this.topic = jmsTemplate.getConnectionFactory().createConnection().createSession().createTopic("entityChange");
    }

    @Around("@annotation(ru.ssau.esa_lab24.annotations.SaveEntityLoggable)")
    private Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        BaseEntity savingEntity = (BaseEntity) Arrays.stream(proceedingJoinPoint.getArgs()).findFirst().get();
        EntityChangeRecord record = new EntityChangeRecord();
        if (savingEntity.getId() == null) {
            record.setChangeType(ChangeType.INSERT);
        } else {
            record.setChangeType(ChangeType.UPDATE);
        }
        BaseEntity result = (BaseEntity) proceedingJoinPoint.proceed();
        record.setEntityId(result.getId());
        jmsTemplate.convertAndSend(topic, record);
        return result;
    }
}
