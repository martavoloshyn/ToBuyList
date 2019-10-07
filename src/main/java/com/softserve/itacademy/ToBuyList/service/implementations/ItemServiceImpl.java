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
        try {
            return itemDAO.getDoneItemsByList(idList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> getUndoneItemsByList(Integer idList) {
        try {
            return itemDAO.getUndoneItemsByList(idList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> filter(String criterion, Integer idList) {
        if (criterion.equals("all")) {
            return getItemsByList(idList);
        }
        boolean isDone = Boolean.parseBoolean(criterion);
        ArrayList<Item> filteredItems = new ArrayList<>();
        if (isDone) {
            filteredItems = getDoneItemsByList(idList);
        } else {
            filteredItems = getUndoneItemsByList(idList);
        }
        return filteredItems;
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
