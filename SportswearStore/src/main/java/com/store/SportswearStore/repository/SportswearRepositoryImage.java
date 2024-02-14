package com.store.SportswearStore.repository;

import com.store.SportswearStore.model.SportswearEntityImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportswearRepositoryImage extends JpaRepository<SportswearEntityImage, Long> {
}