package com.softserve.itacademy.ToBuyList.dao.interfaces;

import com.softserve.itacademy.ToBuyList.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends DAO<Item> {
    ArrayList<Item> getItemsByList(int idList) throws SQLException;

    ArrayList<Item> getDoneItemsByList(int idList) throws SQLException;

    ArrayList<Item> getUndoneItemsByList(int idList) throws SQLException;
}
