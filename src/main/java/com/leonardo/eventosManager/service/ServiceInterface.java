package com.leonardo.eventosManager.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {

    T save(T entity);

    List<T> findALL();

    T update(T entity);

    Optional<T> findById(long id);

    void delete(long id);

}
