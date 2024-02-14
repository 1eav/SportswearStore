package com.store.SportswearStore.service;

import com.store.SportswearStore.DTO.SportswearDtoImage;
import com.store.SportswearStore.model.SportswearEntityImage;
import com.store.SportswearStore.repository.SportswearRepositoryImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageCrudService {
    private final SportswearRepositoryImage repositoryImage;

    public Collection<SportswearDtoImage> getAll() {
        return repositoryImage.findAll().stream().map(ImageCrudService::mapToDto).toList();
    }

    public static SportswearDtoImage mapToDto(SportswearEntityImage entityImage) {
        SportswearDtoImage dtoImage = new SportswearDtoImage();
        dtoImage.setId(entityImage.getId());
        dtoImage.setImageName(entityImage.getImageName());
        dtoImage.setProductId(entityImage.getSportswearEntityProducts().getId());
        return dtoImage;
    }

    public static SportswearEntityImage mapToEntity(SportswearDtoImage dtoImage) {
        SportswearEntityImage entityImage = new SportswearEntityImage();
        entityImage.setId(dtoImage.getId());
        entityImage.setImageName(dtoImage.getImageName());
        return entityImage;
    }
}