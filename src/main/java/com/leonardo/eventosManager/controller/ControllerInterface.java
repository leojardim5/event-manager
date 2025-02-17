package com.leonardo.eventosManager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ControllerInterface<T, ID> {

    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getById(@PathVariable ID id);

    ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity);

    ResponseEntity<Void> delete(@PathVariable ID id);

}
