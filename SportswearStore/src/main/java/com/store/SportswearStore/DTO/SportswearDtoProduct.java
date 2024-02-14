package com.store.SportswearStore.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportswearDtoProduct {
    Long id;
    String category;
    String name;
    String brand;
    String descriptions;
    Float price;
    String size;
    String color;
    List<SportswearDtoImage> sportswearDtoImages;
}