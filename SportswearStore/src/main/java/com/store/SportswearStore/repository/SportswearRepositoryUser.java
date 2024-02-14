package com.store.SportswearStore.repository;

import com.store.SportswearStore.model.SportswearEntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportswearRepositoryUser extends JpaRepository<SportswearEntityUser, Long> {
}