package com.softserve.itacademy.ToBuyList.service.interfaces;

public interface Service<T> {
    void add(T object);

    T get(Integer id);

    void update(T object);

    void delete(Integer id);
}
