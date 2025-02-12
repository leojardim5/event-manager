package com.leonardo.eventosManager.service;

import java.util.List;

public interface ServiceInterface<T> {

    T save(T entity);

    List<T> findALL();

    T update(T entity);

    T findById(long id);

    void delete(long id);

}
