package com.store.SportswearStore.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "admins")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportswearEntityAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    @Column(name = "city")
    String city;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "email")
    String email;
}