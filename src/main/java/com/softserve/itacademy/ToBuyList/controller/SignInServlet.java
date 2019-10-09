package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (userService.isValidAccount(email, password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("id", userService.getUserByEmail(email).getId());

            resp.sendRedirect(req.getContextPath() + "/homePage");
        } else {
            req.setAttribute("error", "Invalid email or password. Please try again.");

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
