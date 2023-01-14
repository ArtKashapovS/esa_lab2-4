package ru.ssau.esa_lab24.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@ToString
@Getter
@Setter
public class Category extends BaseEntity {

    @Column(name = "Category", nullable = false)
    public String name;
}
