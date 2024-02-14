package com.store.SportswearStore.repository;

import com.store.SportswearStore.model.SportswearEntityAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportswearRepositoryAdmin extends JpaRepository<SportswearEntityAdmin, Long> {
}