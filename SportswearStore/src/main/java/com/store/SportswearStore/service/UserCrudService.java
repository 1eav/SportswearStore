package com.store.SportswearStore.service;

import com.store.SportswearStore.DTO.SportswearDtoUser;
import com.store.SportswearStore.model.SportswearEntityUser;
import com.store.SportswearStore.repository.SportswearRepositoryAdmin;
import com.store.SportswearStore.repository.SportswearRepositoryUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserCrudService implements CRUDservice<SportswearDtoUser> {
    private final SportswearRepositoryUser repositoryUser;
    private final SportswearRepositoryAdmin repositoryAdminDouble;

    @Override
    public Collection<SportswearDtoUser> getAll() {
        return repositoryUser.findAll().stream().map(UserCrudService::mapToDto).toList();
    }

    @Override
    public SportswearDtoUser getById(Long id) {
        SportswearEntityUser entityUser = repositoryUser.findById(id).orElseThrow();
        return mapToDto(entityUser);
    }

    @Override
    public void create(SportswearDtoUser item) {
        repositoryUser.save(mapToEntity(item));
    }

    @Override
    public void update(SportswearDtoUser item) {
        repositoryUser.save(mapToEntity(item));
    }

    public void delete(Long id) {
        repositoryUser.deleteById(id);
    }

    public static SportswearDtoUser mapToDto(SportswearEntityUser entityUser) {
        SportswearDtoUser dtoUser = new SportswearDtoUser();
        dtoUser.setId(entityUser.getId());
        dtoUser.setFirstname(entityUser.getFirstname());
        dtoUser.setLastname(entityUser.getLastname());
        dtoUser.setCity(entityUser.getCity());
        dtoUser.setPhoneNumber(entityUser.getPhoneNumber());
        dtoUser.setEmail(entityUser.getEmail());
        return dtoUser;
    }

    public static SportswearEntityUser mapToEntity(SportswearDtoUser dtoUser) {
        SportswearEntityUser entityUser = new SportswearEntityUser();
        entityUser.setId(dtoUser.getId());
        entityUser.setFirstname(dtoUser.getFirstname());
        entityUser.setLastname(dtoUser.getLastname());
        entityUser.setCity(dtoUser.getCity());
        entityUser.setPhoneNumber(dtoUser.getPhoneNumber());
        entityUser.setEmail(dtoUser.getEmail());
        return entityUser;
    }
}