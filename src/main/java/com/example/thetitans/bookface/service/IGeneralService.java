package com.example.thetitans.bookface.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<T> {

    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll();

    T save(T t);

    T findById(Long id);

    void delete(Long id);
}
