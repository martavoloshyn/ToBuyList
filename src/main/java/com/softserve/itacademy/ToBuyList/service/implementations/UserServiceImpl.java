package com.softserve.itacademy.ToBuyList.service.implementations;

import com.softserve.itacademy.ToBuyList.dao.implementations.UserDAOImpl;
import com.softserve.itacademy.ToBuyList.dao.interfaces.UserDAO;
import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.service.interfaces.UserService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

    public String encodePassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isValidEmail(String email) {
        ArrayList<String> allEmails = getAllEmails();
        if (allEmails.contains(email)) {
            return false;
        } else {
            return true;
        }
    }

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public User getUserByEmail(String email) {
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
