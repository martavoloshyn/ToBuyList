package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.service.implementations.ListServiceImpl;
import com.softserve.itacademy.ToBuyList.service.interfaces.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/homePage")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListService listService = new ListServiceImpl();
        HttpSession httpSession = req.getSession(false);

        ArrayList<List> listsByUser = listService
                .getListsByUser((Integer) httpSession.getAttribute("id"));
        req.setAttribute("listsByUser", listsByUser);

        req.getRequestDispatcher("webapp/pages/home.jsp").forward(req, resp);
    }
}
