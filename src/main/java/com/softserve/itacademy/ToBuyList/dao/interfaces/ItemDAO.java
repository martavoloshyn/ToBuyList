package com.softserve.itacademy.ToBuyList.dao.interfaces;

import com.softserve.itacademy.ToBuyList.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends DAO<Item> {
    ArrayList<Item> getItemsByList(Integer idList) throws SQLException;

    ArrayList<Item> getDoneItemsByList(Integer idList) throws SQLException;

    ArrayList<Item> getUndoneItemsByList(Integer idList) throws SQLException;
}
