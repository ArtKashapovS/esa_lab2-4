package ru.ssau.esa_lab24.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ssau.esa_lab24.enums.ChangeType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ENTITY_CHANGE_LOG")
@ToString
@Getter
@Setter
public class EntityChangeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ENTITY_ID")
    private Integer entityId;

    @Column(name = "CHANGE_DATE")
    private LocalDate changeDate;

    @Column(name = "CHANGE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private ChangeType changeType;
}
