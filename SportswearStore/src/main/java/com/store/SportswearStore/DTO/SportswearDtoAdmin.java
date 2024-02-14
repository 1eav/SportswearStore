package com.store.SportswearStore.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportswearDtoAdmin {
    Long id;
    String firstname;
    String lastname;
    String city;
    String phoneNumber;
    String email;
}