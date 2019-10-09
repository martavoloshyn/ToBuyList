package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.ItemDAO;
import com.softserve.itacademy.ToBuyList.entity.Item;
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
        String query = "SELECT iditem, idlist, text, createdate, updatedate, isdone FROM item WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idList);
        return getItems(statement);
    }

    @Override
    public ArrayList<Item> getDoneItemsByList(Integer idList) throws SQLException {
        String query = "SELECT iditem, idlist, text, createdate, updatedate, isdone FROM item WHERE idlist=? AND isdone=true";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idList);
        return getItems(statement);
    }

    private ArrayList<Item> getItems(PreparedStatement statement) throws SQLException {
        ArrayList<Item> items = new ArrayList<>();

        ResultSet set = statement.executeQuery();
        while (set.next()) {
            items.add(getNextItem(set));
        }

        set.close();
        statement.close();
        return items;
    }

    private Item getNextItem(ResultSet set) throws SQLException {
        Item item = new Item();
        setItem(item, set);
        return item;
    }

    @Override
    public ArrayList<Item> getUndoneItemsByList(Integer idList) throws SQLException {
        String query = "SELECT iditem, idlist, text, createdate, updatedate, isdone FROM item WHERE idlist=? AND isdone=false";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idList);
        return getItems(statement);
    }

    @Override
    public void add(Item item) throws SQLException {
        String query = "INSERT INTO item (idlist, text, createdate,updatedate, isdone) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(item, statement);
        statement.execute();

        statement.close();
    }

    private void prepareStatement(Item item, PreparedStatement statement) throws SQLException {
        statement.setInt(1, item.getIdList());
        statement.setString(2, item.getText());
        statement.setDate(3, Date.valueOf(item.getCreateDate()));
        statement.setDate(4, Date.valueOf(item.getUpdateDate()));
        statement.setBoolean(5, item.getDone());
    }

    @Override
    public Item get(Integer id) throws SQLException {
        String query = "SELECT iditem, idlist, text, createdate, updatedate, isdone FROM item WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        Item item = new Item();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            setItem(item, set);
        }

        set.close();
        statement.close();
        return item;
    }

    private void setItem(Item item, ResultSet set) throws SQLException {
        item.setId(set.getInt("iditem"));
        item.setIdList(set.getInt("idlist"));
        item.setText(set.getString("text"));
        item.setCreateDate(set.getDate("createdate").toLocalDate());
        item.setUpdateDate(set.getDate("updatedate").toLocalDate());
        item.setDone(set.getBoolean("isdone"));
    }

    @Override
    public void update(Item item) throws SQLException {
        String query = "UPDATE item SET idlist=?, text=?, createdate=?, updatedate=?, isdone=?  WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(item, statement);
        statement.setInt(6, item.getId());
        statement.execute();

        statement.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM item WHERE iditem=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();

        statement.close();
    }
}
