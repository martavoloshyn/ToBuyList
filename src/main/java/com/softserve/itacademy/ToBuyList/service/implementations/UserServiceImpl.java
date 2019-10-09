package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.UserDAOImpl;
import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.service.interfaces.UserService;
import com.softserve.itacademy.ToBuyList.util.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    public boolean isValidEmail(String email) {
        ArrayList<String> allEmails = getAllEmails();
        return !allEmails.contains(email);
    }

    public boolean isValidUsername(String username) {
        ArrayList<String> allUsernames = getAllUsernames();
        return !allUsernames.contains(username);
    }

    public boolean isValid(String email, String password) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();

        User user = getUserByEmail(email);
        if (user == null) {
            return false;
        } else {
            return passwordEncoder.encodePassword(password).equals(user.getPassword());
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return userDAO.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllEmails() {
        try {
            return userDAO.getAllEmails();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllUsernames() {
        try {
            return userDAO.getAllUsernames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(User object) {
        try {
            userDAO.add(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public void update(User object) {

    }

    @Override
    public void delete(Integer id) {

    }
}
