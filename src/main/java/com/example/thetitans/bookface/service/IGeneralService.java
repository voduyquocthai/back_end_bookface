package com.example.thetitans.bookface.service;


import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<T> {

    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void delete(Long id);
}
