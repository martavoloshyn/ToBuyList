package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.ItemDAO;
import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    private Connection connection;

    public ItemDAOImpl() {
        connection = DBConnection.getConnection();
    }
    @Override
    public ArrayList<Item> getItemsByList(Integer idList) throws SQLException {
        String query = "SELECT * FROM item WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idList);
        return getItems(statement);
    }

    @Override
    public ArrayList<Item> getDoneItemsByList(Integer idList) throws SQLException {
        String query = "SELECT * FROM item WHERE idlist=? AND isdone=true";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idList);
        return getItems(statement);
    }

    private ArrayList<Item> getItems(PreparedStatement statement) throws SQLException {
        ArrayList<Item> items = new ArrayList<Item>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Item item = new Item();
            item.setId(set.getInt("iditem"));
            item.setIdList(set.getInt("idlist"));
            item.setText(set.getString("text"));
            item.setCreateDate(set.getDate("createdate").toLocalDate());
            item.setUpdateDate(set.getDate("updatedate").toLocalDate());
            item.setDone(set.getBoolean(("isdone")));
            items.add(item);
        }
        set.close();
        statement.close();
        return items;
    }

    @Override
    public ArrayList<Item> getUndoneItemsByList(Integer idList) throws SQLException {
        String query = "SELECT * FROM item WHERE idlist=? AND isdone=false";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idList);
        return getItems(statement);
    }

    @Override
    public void add(Item object) throws SQLException {
        String query = "INSERT INTO item (idlist, text, createdate,updatedate, isdone ) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,object.getIdList());
        statement.setString(2, object.getText());
        statement.setDate(3, Date.valueOf(object.getCreateDate()));
        statement.setDate(4,Date.valueOf(object.getUpdateDate()));
        statement.setBoolean(5,object.getDone());
        statement.execute();
        statement.close();
    }

    @Override
    public Item get(Integer id) throws SQLException {
        String query = "SELECT * FROM item WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet set = statement.executeQuery();
        Item item = new Item();
        if (set.next()) {
            item.setId(set.getInt("iditem"));
            item.setIdList(set.getInt("idlist"));
            item.setText(set.getString("text"));
            item.setCreateDate(set.getDate("createdate").toLocalDate());
            item.setUpdateDate(set.getDate("updatedate").toLocalDate());
            item.setDone(set.getBoolean("isdone"));
        }
        set.close();
        statement.close();
        return item;
    }

    @Override
    public void update(Item object) throws SQLException {
        String query = "UPDATE item SET idlist=?, text=?, createdate=?, updatedate=?, isdone=?  WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,object.getIdList());
        statement.setString(2, object.getText());
        statement.setDate(3,Date.valueOf(object.getCreateDate()));
        statement.setDate(4,Date.valueOf(object.getUpdateDate()));
        statement.setBoolean(5,object.getDone());
        statement.setInt(6,object.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM item WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.execute();
        statement.close();
    }
}
