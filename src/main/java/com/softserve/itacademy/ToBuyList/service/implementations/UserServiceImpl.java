package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.UserDAOImpl;
import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.service.interfaces.UserService;
import com.softserve.itacademy.ToBuyList.util.PasswordEncoder;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    public boolean isValidEmail(String email) {
        return !getAllEmails().contains(email);
    }

    public boolean isValidUsername(String username) {
        return !getAllUsernames().contains(username);
    }

    public boolean isValidAccount(String email, String password) {
        User user = getUserByEmail(email);
        if (user != null) {
            return PasswordEncoder.encodePassword(password).equals(user.getPassword());
        }
        return false;
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
    public void add(User user) {
        try {
            userDAO.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }
}
