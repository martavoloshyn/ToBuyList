package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.ItemDAOImpl;
import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.service.interfaces.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemServiceImpl implements ItemService {

    private ItemDAOImpl itemDAO;

    public ItemServiceImpl() {
        itemDAO = new ItemDAOImpl();
    }

    @Override
    public ArrayList<Item> getItemsByList(Integer idList) {
        try {
            return itemDAO.getItemsByList(idList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> getDoneItemsByList(Integer idList) {
        return null;
    }

    @Override
    public ArrayList<Item> getUndoneItemsByList(Integer idList) {
        return null;
    }

    @Override
    public void add(Item object) {

    }

    @Override
    public Item get(Integer id) {
        return null;
    }

    @Override
    public void update(Item object) {

    }

    @Override
    public void delete(Integer id) {

    }
}
