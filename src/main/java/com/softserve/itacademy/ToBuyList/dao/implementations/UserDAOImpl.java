package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.UserDAO;
import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM user WHERE email=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet set = statement.executeQuery();
        return getUser(statement, set);
    }

    @Override
    public ArrayList<String> getAllEmails() throws SQLException {
        String query = "SELECT email FROM user";
        Statement statement = connection.prepareStatement(query);
        ArrayList<String> emails = new ArrayList<>();
        ResultSet set = statement.executeQuery(query);
        while (set.next()) {
            emails.add(set.getString("email"));
        }
        set.close();
        statement.close();
        return emails;
    }

    @Override
    public ArrayList<String> getAllUsernames() throws SQLException {
        String query = "SELECT username FROM user";
        Statement statement = connection.prepareStatement(query);
        ArrayList<String> usernames = new ArrayList<>();
        ResultSet set = statement.executeQuery(query);
        while (set.next()) {
            usernames.add(set.getString("username"));
        }
        set.close();
        statement.close();
        return usernames;
    }

    @Override
    public void add(User object) throws SQLException {
        String query = "INSERT INTO user (email, password, username) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,object.getEmail());
        statement.setString(2,object.getPassword());
        statement.setString(3,object.getUsername());
        statement.execute();
        statement.close();
    }

    @Override
    public User get(Integer id) throws SQLException {
        String query = "SELECT * FROM user WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        return getUser(statement, set);
    }

    private User getUser(PreparedStatement statement, ResultSet set) throws SQLException {
        User user = new User();
        if (set.next()) {
            user.setId(set.getInt("iduser"));
            user.setEmail(set.getString("email"));
            user.setPassword(set.getString("password"));
            user.setUsername(set.getString("username"));
        }
        set.close();
        statement.close();
        return user;
    }

    @Override
    public void update(User object) throws SQLException {
        String query = "UPDATE user SET email=?, password=?, username=?  WHERE iduser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,object.getEmail());
        statement.setString(2,object.getPassword());
        statement.setString(3,object.getUsername());
        statement.setInt(4,object.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM user WHERE iduser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.execute();
        statement.close();
    }
}
