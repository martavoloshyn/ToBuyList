package com.softserve.itacademy.ToBuyList.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.softserve.itacademy.ToBuyList.entity.List;

public interface ListDAO extends DAO<List> {
    ArrayList<List> getListsByUser(int idUser) throws SQLException;

    ArrayList<List> getDoneListsByUser(int idUser) throws SQLException;

    ArrayList<List> getUndoneListsByUser(int idUser) throws SQLException;
}
