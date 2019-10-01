package com.softserve.itacademy.ToBuyList.dao.interfaces;

import com.softserve.itacademy.ToBuyList.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO extends DAO<User> {
    User getUserByEmail(String email) throws SQLException;

    ArrayList<String> getAllEmails() throws SQLException;

    ArrayList<String> getAllUsernames() throws SQLException;
}
