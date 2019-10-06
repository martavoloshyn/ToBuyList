package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.entity.User;
import com.softserve.itacademy.ToBuyList.service.implementations.UserServiceImpl;
import com.softserve.itacademy.ToBuyList.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        if (userService.isValidEmail(email) && userService.isValidUsername(username)) {
            User user = new User(email, userService.encodePassword(password),username);
            userService.add(user);
            req.setAttribute("id", user.getId());
            req.getRequestDispatcher("/homePage").forward(req,resp);
        } else {
            req.setAttribute("error", "This email or username is already used. Please try another one.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
