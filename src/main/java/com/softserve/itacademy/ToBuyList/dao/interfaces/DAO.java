package com.softserve.itacademy.ToBuyList.dao.interfaces;

import java.sql.SQLException;

public interface DAO<T> {
    void add(T object) throws SQLException;

    T get(Integer id) throws SQLException;

    void update(T object) throws SQLException;

    void delete(Integer id) throws SQLException;
}
