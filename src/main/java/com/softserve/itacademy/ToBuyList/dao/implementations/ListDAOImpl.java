package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.ListDAO;
import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ListDAOImpl implements ListDAO {

    private Connection connection;

    public ListDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public ArrayList<List> getListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT idlist, iduser, name, createdate, updatedate, isdone FROM list WHERE iduser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idUser);
        return getLists(statement);
    }

    @Override
    public ArrayList<List> getDoneListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT idlist, iduser, name, createdate, updatedate, isdone FROM list WHERE iduser=? AND isdone=true";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idUser);
        return getLists(statement);
    }

    private ArrayList<List> getLists(PreparedStatement statement) throws SQLException {
        ArrayList<List> lists = new ArrayList<>();

        ResultSet set = statement.executeQuery();
        while (set.next()) {
            lists.add(getNextList(set));
        }

        set.close();
        statement.close();
        return lists;
    }

    private List getNextList(ResultSet set) throws SQLException {
        List list = new List();
        prepareStatement(set, list);
        return list;
    }

    private void prepareStatement(ResultSet set, List list) throws SQLException {
        list.setId(set.getInt("idlist"));
        list.setIdUser(set.getInt("iduser"));
        list.setName(set.getString("name"));
        list.setCreateDate(set.getDate("createdate").toLocalDate());
        list.setUpdateDate(set.getDate("updatedate").toLocalDate());
        list.setDone(set.getBoolean("isdone"));
    }

    @Override
    public ArrayList<List> getUndoneListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT idlist, iduser, name, createdate, updatedate, isdone FROM list WHERE iduser=? AND isdone=false";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idUser);
        return getLists(statement);
    }

    @Override
    public void add(List list) throws SQLException {
        String query = "INSERT INTO list (iduser, name, createdate,updatedate, isdone ) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(list, statement);
        statement.execute();

        statement.close();
    }

    private void prepareStatement(List list, PreparedStatement statement) throws SQLException {
        statement.setInt(1, list.getIdUser());
        statement.setString(2, list.getName());
        statement.setDate(3, Date.valueOf(list.getCreateDate()));
        statement.setDate(4, Date.valueOf(list.getUpdateDate()));
        statement.setBoolean(5, list.getDone());
    }

    @Override
    public List get(Integer id) throws SQLException {
        String query = "SELECT idlist, iduser, name, createdate, updatedate, isdone FROM list WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        List list = new List();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            prepareStatement(set, list);
        }

        set.close();
        statement.close();
        return list;
    }

    @Override
    public void update(List object) throws SQLException {
        String query = "UPDATE list SET iduser=?, name=?, createdate=?, updatedate=?, isdone=?  WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(object, statement);
        statement.setInt(6, object.getId());
        statement.execute();

        statement.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM list WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();

        statement.close();
    }
}
