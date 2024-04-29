package com.projet_QCM.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OjectService<T> {
    T create(T t);
    List<T>getAll();
    T getById(long id);
    void delete(Long id);
    T update(T t, long id);


}
