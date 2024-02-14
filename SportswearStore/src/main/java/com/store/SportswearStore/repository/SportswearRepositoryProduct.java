package com.store.SportswearStore.repository;

import com.store.SportswearStore.model.SportswearEntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportswearRepositoryProduct extends JpaRepository<SportswearEntityProduct, Long> {
    @Query(value = "SELECT s FROM SportswearEntityProduct s WHERE s.category LIKE %?1%"
            + " OR s.name LIKE %?1%"
            + " OR s.brand LIKE %?1%"
            + " OR s.descriptions LIKE %?1%"
            + " OR s.size LIKE %?1%"
            + " OR s.color LIKE %?1%")
    List<SportswearEntityProduct> findAll(@Param("keyword") String keyword);
}