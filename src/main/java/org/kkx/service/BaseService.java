package org.kkx.service;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BaseService<T> {

    Page<T> findAll(int pageNumber, int pageSize);
    T createOne(T t);
    T updateOne(T t);
    void deleteOneById(Long id);
    Optional<T> findOneById(Long id);

}
