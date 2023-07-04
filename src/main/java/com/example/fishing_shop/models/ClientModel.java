package com.example.fishing_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "wanted_item")
    String  item;
    @Column(name = "contact")
    String contact;

    @Column(name = "actual")
    boolean actual;

}
