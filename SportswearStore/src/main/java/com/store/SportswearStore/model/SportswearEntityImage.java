package com.store.SportswearStore.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "images")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportswearEntityImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "image_name")
    String imageName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    SportswearEntityProduct sportswearEntityProducts;
}