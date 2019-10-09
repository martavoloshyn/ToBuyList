package com.softserve.itacademy.ToBuyList.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        httpSession.removeAttribute("id");
        httpSession.invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
