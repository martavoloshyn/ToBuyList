package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.UserServiceImpl;
import com.softserve.itacademy.ToBuyList.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if(userService.isValidEmail(email)){

        } else {
            req.setAttribute("error","This email is already used. Please try another one.");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
