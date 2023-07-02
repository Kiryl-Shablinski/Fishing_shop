package com.example.fishing_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title")
    String title;

     @Column(name = "short_disc")
    String disc;

     @Column(name = "photo_url")
    String url;

}
