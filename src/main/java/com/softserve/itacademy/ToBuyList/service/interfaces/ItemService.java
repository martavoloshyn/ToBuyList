package com.softserve.itacademy.ToBuyList.service.interfaces;

import com.softserve.itacademy.ToBuyList.entity.Item;

import java.util.ArrayList;

public interface ItemService extends Service<Item> {
    ArrayList<Item> getItemsByList(Integer idList);

    ArrayList<Item> getDoneItemsByList(Integer idList);

    ArrayList<Item> getUndoneItemsByList(Integer idList);

    ArrayList<Item> filter(String criterion,Integer idList);

    void changeDoneById (Integer idItem);
}
