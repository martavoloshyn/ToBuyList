package com.softserve.itacademy.ToBuyList.service.interfaces;

import com.softserve.itacademy.ToBuyList.entity.List;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ListService extends Service<List> {
    ArrayList<List> getListsByUser(Integer idUser);

    ArrayList<List> getDoneListsByUser(Integer idUser);

    ArrayList<List> getUndoneListsByUser(Integer idUser);

    public ArrayList<List> filter(String criterion, Integer idUser);

    void changeDoneById (Integer idList);

    void createList(Integer idUser,String newListName);

    void updateList(Integer idList,String newListName);
}
