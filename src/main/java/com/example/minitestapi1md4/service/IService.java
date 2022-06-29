package com.example.minitestapi1md4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IService<T> {
    void save(T t);

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void remove(Long id);


}
