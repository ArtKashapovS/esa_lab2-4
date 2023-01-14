package ru.ssau.esa_lab24.jms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ssau.esa_lab24.enums.ChangeType;

@ToString
@Getter
@Setter
public class EntityChangeRecord {
    private Integer entityId;
    private ChangeType changeType;
}
