package ru.ssau.esa_lab24.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Product")
@ToString
@Getter
@Setter
public class Product extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    private Category category;


    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "image", nullable = false)
    private String image;
}
