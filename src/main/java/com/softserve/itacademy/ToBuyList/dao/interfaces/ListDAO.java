package com.softserve.itacademy.ToBuyList.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.softserve.itacademy.ToBuyList.entity.List;

public interface ListDAO extends DAO<List> {
    ArrayList<List> getListsByUser(Integer idUser) throws SQLException;

    ArrayList<List> getDoneListsByUser(Integer idUser) throws SQLException;

    ArrayList<List> getUndoneListsByUser(Integer idUser) throws SQLException;
}
