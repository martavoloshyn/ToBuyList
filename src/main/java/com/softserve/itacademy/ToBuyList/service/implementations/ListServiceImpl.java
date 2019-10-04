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
        try {
            return listDAO.getListsByUser(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<List> getDoneListsByUser(Integer idUser) {
        return null;
    }

    @Override
    public ArrayList<List> getUndoneListsByUser(Integer idUser) {
        return null;
    }

    @Override
    public void add(List object) {

    }

    @Override
    public List get(Integer id) {
        return null;
    }

    @Override
    public void update(List object) {

    }

    @Override
    public void delete(Integer id) {

    }
}
