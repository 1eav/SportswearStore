package com.store.SportswearStore.service;

import java.util.Collection;

public interface CRUDservice<T> {
    Collection<T> getAll();
    T getById(Long id);
    void create(T item);
    void update(T item);
    void delete(Long id);
}