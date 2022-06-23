package com.example.minitestapi.service;

import java.util.Optional;

public interface GeneralService<T> {
    T save(T object);

    void delete(Long id);

    Iterable<T> findAll();

    Optional<T> findById(Long id);
}