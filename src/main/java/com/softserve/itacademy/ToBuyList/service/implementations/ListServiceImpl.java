package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.ListDAOImpl;
import com.softserve.itacademy.ToBuyList.dao.interfaces.ListDAO;
import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.service.interfaces.ListService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ListServiceImpl implements ListService {
    private ListDAOImpl listDAO;

    public ListServiceImpl(){
        listDAO = new ListDAOImpl();
    }
    @Override
    public ArrayList<List> getListsByUser(Integer idUser) {
        System.out.println(idUser);
        try {
            return listDAO.getListsByUser(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<List> filter(String criterion, Integer idUser) {
        if (criterion.equals("all")) {
            return getListsByUser(idUser);
        }
        boolean isDone = Boolean.parseBoolean(criterion);
        ArrayList<List> filteredLists = new ArrayList<>();
        if (isDone) {
            filteredLists = getDoneListsByUser(idUser);
        } else {
            filteredLists = getUndoneListsByUser(idUser);
        }
        return filteredLists;
    }

    @Override
    public void changeDoneById(Integer idList) {
        List list = get(idList);
        list.setDone(!list.getDone());
        update(list);
    }

    @Override
    public ArrayList<List> getDoneListsByUser(Integer idUser) {
        try {
            return listDAO.getDoneListsByUser(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<List> getUndoneListsByUser(Integer idUser) {
        try {
            return
                    listDAO.getUndoneListsByUser(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(List object) {

    }

    @Override
    public List get(Integer id) {
        try {
            return listDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(List object) {
        try {
            listDAO.update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }
}
