package ru.ssau.esa_lab24.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@ToString
@Getter
@Setter
public class Order extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Item> items;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "create_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDT;

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }
}
