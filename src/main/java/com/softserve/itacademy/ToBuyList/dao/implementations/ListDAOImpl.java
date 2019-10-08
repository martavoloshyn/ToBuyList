package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.ListDAO;
import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.jdbc.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListDAOImpl implements ListDAO {
    private Connection connection;

    public ListDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public ArrayList<List> getListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT * FROM list WHERE iduser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idUser);
        return getLists(statement);
    }

    @Override
    public ArrayList<List> getDoneListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT * FROM list WHERE iduser=? AND isdone=true";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idUser);
        return getLists(statement);
    }

    private ArrayList<List> getLists(PreparedStatement statement) throws SQLException {
        ArrayList<List> lists = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            List list = new List();
            list.setId(set.getInt("idlist"));
            list.setIdUser(set.getInt("iduser"));
            list.setName(set.getString("name"));
            list.setCreateDate(set.getDate("createdate").toLocalDate());
            list.setUpdateDate(set.getDate("updatedate").toLocalDate());
            list.setDone(set.getBoolean("isdone"));
            lists.add(list);
        }
        set.close();
        statement.close();
        return lists;
    }

    @Override
    public ArrayList<List> getUndoneListsByUser(Integer idUser) throws SQLException {
        String query = "SELECT * FROM list WHERE iduser=? AND isdone=false";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idUser);
        return getLists(statement);
    }

    @Override
    public void add(List object) throws SQLException {
        String query = "INSERT INTO list (idlist, iduser, name, createdate,updatedate, isdone ) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,object.getId());
        statement.setInt(2,object.getIdUser());
        statement.setString(3, object.getName());
        statement.setDate(4,Date.valueOf(object.getCreateDate()));
        statement.setDate(5,Date.valueOf(object.getUpdateDate()));
        statement.setBoolean(6,object.getDone());
        statement.execute();
        statement.close();
    }

    @Override
    public List get(Integer id) throws SQLException {
        String query = "SELECT * FROM list WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet set = statement.executeQuery();
        List list = new List();
        if (set.next()) {
            list.setId(set.getInt("idlist"));
            list.setIdUser(set.getInt("iduser"));
            list.setName(set.getString("name"));
            list.setCreateDate(set.getDate("createdate").toLocalDate());
            list.setUpdateDate(set.getDate("updatedate").toLocalDate());
            list.setDone(set.getBoolean("isdone"));
        }
        set.close();
        statement.close();
        return list;
    }

    @Override
    public void update(List object) throws SQLException {
        String query = "UPDATE list SET iduser=?, name=?, createdate=?, updatedate=?, isdone=?  WHERE idlist=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,object.getIdUser());
        statement.setString(2, object.getName());
        statement.setDate(3,Date.valueOf(object.getCreateDate()));
        statement.setDate(4,Date.valueOf(object.getUpdateDate()));
        statement.setBoolean(5,object.getDone());
        statement.setInt(6,object.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM list WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.execute();
        statement.close();
    }
}
