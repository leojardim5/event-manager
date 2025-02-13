package com.leonardo.eventosManager.controller;

import java.util.List;
import java.util.Optional;

public interface ControllerInterface<T> {

    T save(T entity);

    Optional<T> findById(long id);

    List<T> findAll();

    void deleteById(long id);

    T update(T entity);

}
