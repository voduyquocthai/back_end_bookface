package com.example.thetitans.bookface.service;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    T save(T t);

    T findById(Long id);

    void delete(Long id);
}
