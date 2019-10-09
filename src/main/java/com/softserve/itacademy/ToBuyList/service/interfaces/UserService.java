package com.softserve.itacademy.ToBuyList.service.interfaces;

import com.softserve.itacademy.ToBuyList.entity.User;

import java.util.ArrayList;

public interface UserService extends Service<User> {
    User getUserByEmail(String email);

    ArrayList<String> getAllEmails();

    ArrayList<String> getAllUsernames();
}
