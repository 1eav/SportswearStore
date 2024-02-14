package com.store.SportswearStore.service;

import com.store.SportswearStore.DTO.SportswearDtoAdmin;
import com.store.SportswearStore.model.SportswearEntityAdmin;
import com.store.SportswearStore.repository.SportswearRepositoryAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminCrudService implements CRUDservice<SportswearDtoAdmin> {
    private final SportswearRepositoryAdmin repositoryAdmin;

    @Override
    public Collection<SportswearDtoAdmin> getAll() {
        return repositoryAdmin.findAll().stream().map(AdminCrudService::mapToDto).toList();
    }

    @Override
    public SportswearDtoAdmin getById(Long id) {
        return mapToDto(repositoryAdmin.findById(id).orElseThrow());
    }

    @Override
    public void create(SportswearDtoAdmin item) {
        repositoryAdmin.save(mapToEntity(item));
    }

    @Override
    public void update(SportswearDtoAdmin item) {
        repositoryAdmin.save(mapToEntity(item));
    }

    @Override
    public void delete(Long id) {
        repositoryAdmin.deleteById(id);
    }

    public static SportswearDtoAdmin mapToDto(SportswearEntityAdmin entityAdmin) {
        SportswearDtoAdmin dtoAdmin = new SportswearDtoAdmin();
        dtoAdmin.setId(entityAdmin.getId());
        dtoAdmin.setFirstname(entityAdmin.getFirstname());
        dtoAdmin.setLastname(entityAdmin.getLastname());
        dtoAdmin.setCity(entityAdmin.getCity());
        dtoAdmin.setPhoneNumber(entityAdmin.getPhoneNumber());
        dtoAdmin.setEmail(entityAdmin.getEmail());
        return dtoAdmin;
    }

    public static SportswearEntityAdmin mapToEntity(SportswearDtoAdmin dtoAdmin) {
        SportswearEntityAdmin entityAdmin = new SportswearEntityAdmin();
        entityAdmin.setId(dtoAdmin.getId());
        entityAdmin.setFirstname(dtoAdmin.getFirstname());
        entityAdmin.setLastname(dtoAdmin.getLastname());
        entityAdmin.setCity(dtoAdmin.getCity());
        entityAdmin.setPhoneNumber(dtoAdmin.getPhoneNumber());
        entityAdmin.setEmail(dtoAdmin.getEmail());
        return entityAdmin;
    }
}