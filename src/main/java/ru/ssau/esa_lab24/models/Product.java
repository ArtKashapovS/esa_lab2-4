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

    @Column(name = "count", nullable = false)
    private int count;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private Seller seller;

    @Column(name = "image", nullable = false)
    private String image;
}
