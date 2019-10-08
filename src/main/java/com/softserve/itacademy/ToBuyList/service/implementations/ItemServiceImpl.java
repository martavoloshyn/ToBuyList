package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.ItemDAOImpl;
import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.service.interfaces.ItemService;

import java.sql.SQLException;
import java.time.LocalDate;
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
    public void changeDoneById(Integer idItem) {
        Item item = get(idItem);
        item.setDone(!item.getDone());
        update(item);
    }

    @Override
    public void createItem(Integer idList, String newItemText) {
        Item newItem = new Item(idList,newItemText, LocalDate.now(),LocalDate.now(),false);
        System.out.println(newItem);
        add(newItem);
    }

    @Override
    public void add(Item object) {
        try {
            itemDAO.add(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item get(Integer id) {
        try {
            return itemDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Item object) {
        try {
            itemDAO.update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            itemDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
