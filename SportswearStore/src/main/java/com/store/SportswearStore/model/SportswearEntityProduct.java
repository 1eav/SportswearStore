package com.store.SportswearStore.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportswearEntityProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "category")
    String category;

    @Column(name = "name")
    String name;

    @Column(name = "brand")
    String brand;

    @Column(name = "descriptions")
    String descriptions;

    @Column(name = "price")
    Float price;

    @Column(name = "size")
    String size;

    @Column(name = "color")
    String color;

    @OneToMany(mappedBy = "sportswearEntityProducts", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<SportswearEntityImage> sportswearEntityImages;
}