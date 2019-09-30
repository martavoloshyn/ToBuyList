package com.softserve.itacademy.ToBuyList.dao.interfaces;

import java.sql.SQLException;

public interface DAO<T> {
    void add(T object) throws SQLException;

    T get(int id) throws SQLException;

    void update(T object) throws SQLException;

    void delete(int id) throws SQLException;
}
