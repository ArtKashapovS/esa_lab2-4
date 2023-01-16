package ru.ssau.esa_lab24.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Seller")
@ToString
@Getter
@Setter
public class Seller extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name="email", nullable = false)
    private String email;

    public String getFullName() {
        return String.format("%s %s %s", getLastName(), getFirstName(), getPatronymicName());
    }
}
