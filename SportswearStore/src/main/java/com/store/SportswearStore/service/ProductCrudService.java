package com.store.SportswearStore.service;

import com.store.SportswearStore.DTO.SportswearDtoProduct;
import com.store.SportswearStore.model.SportswearEntityProduct;
import com.store.SportswearStore.repository.SportswearRepositoryProduct;
import com.store.SportswearStore.repository.SportswearRepositoryUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductCrudService implements CRUDservice<SportswearDtoProduct> {
    private final SportswearRepositoryProduct repositoryProduct;
    private final SportswearRepositoryUser repositoryUserDouble;

    public List<SportswearDtoProduct> listAll(String keyword) {
        if (keyword != null) {
            return repositoryProduct.findAll(keyword).stream().map(ProductCrudService::mapToDto).toList();
        }
        return repositoryProduct.findAll().stream().map(ProductCrudService::mapToDto).toList();
    }

    @Override
    public Collection<SportswearDtoProduct> getAll() {
        return repositoryProduct.findAll().stream().map(ProductCrudService::mapToDto).toList();
    }

    @Override
    public SportswearDtoProduct getById(Long id) {
        SportswearEntityProduct entityProduct = repositoryProduct.findById(id).orElseThrow();
        return mapToDto(entityProduct);
    }

    @Override
    public void create(SportswearDtoProduct item) {
        repositoryProduct.save(mapToEntity(item));
    }

    @Override
    public void update(SportswearDtoProduct item) {
        repositoryProduct.save(mapToEntity(item));
    }

    @Override
    public void delete(Long id) {
        repositoryProduct.deleteById(id);
    }

    public static SportswearDtoProduct mapToDto(SportswearEntityProduct entityProduct) {
        SportswearDtoProduct dtoProduct = new SportswearDtoProduct();
        dtoProduct.setId(entityProduct.getId());
        dtoProduct.setCategory(entityProduct.getCategory());
        dtoProduct.setName(entityProduct.getName());
        dtoProduct.setBrand(entityProduct.getBrand());
        dtoProduct.setDescriptions(entityProduct.getDescriptions());
        dtoProduct.setPrice(entityProduct.getPrice());
        dtoProduct.setSize(entityProduct.getSize());
        dtoProduct.setColor(entityProduct.getColor());
        dtoProduct.setSportswearDtoImages(entityProduct.getSportswearEntityImages().stream().map(ImageCrudService::mapToDto).toList());
        return dtoProduct;
    }

    public static SportswearEntityProduct mapToEntity(SportswearDtoProduct dtoProduct) {
        SportswearEntityProduct entityProduct = new SportswearEntityProduct();
        entityProduct.setId(dtoProduct.getId());
        entityProduct.setCategory(dtoProduct.getCategory());
        entityProduct.setName(dtoProduct.getName());
        entityProduct.setBrand(dtoProduct.getBrand());
        entityProduct.setDescriptions(dtoProduct.getDescriptions());
        entityProduct.setPrice(dtoProduct.getPrice());
        entityProduct.setSize(dtoProduct.getSize());
        entityProduct.setColor(dtoProduct.getColor());
        entityProduct.setSportswearEntityImages(dtoProduct.getSportswearDtoImages().stream().map(ImageCrudService::mapToEntity).toList());
        return entityProduct;
    }
}