package com.softserve.itacademy.ToBuyList.dao.implementations;

import com.softserve.itacademy.ToBuyList.dao.interfaces.UserDAO;
import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.jdbc.DBConnection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT iduser, email, password, username FROM user WHERE email=?";
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
    public void add(User user) throws SQLException {
        String query = "INSERT INTO user (email, password, username) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        prepareStatement(user, statement);
        statement.execute();

        statement.close();
    }

    private void prepareStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getUsername());
    }

    @Override
    public User get(Integer id) {
        throw new NotImplementedException();
    }

    private User getUser(PreparedStatement statement, ResultSet set) throws SQLException {
        User user = new User();

        if (set.next()) {
            setUser(set, user);
        }

        set.close();
        statement.close();
        return user;
    }

    private void setUser(ResultSet set, User user) throws SQLException {
        user.setId(set.getInt("iduser"));
        user.setEmail(set.getString("email"));
        user.setPassword(set.getString("password"));
        user.setUsername(set.getString("username"));
    }

    @Override
    public void update(User user) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Integer id) {
        throw new NotImplementedException();
    }
}
