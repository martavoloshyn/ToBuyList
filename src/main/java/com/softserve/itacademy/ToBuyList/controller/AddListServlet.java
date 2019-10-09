package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addList")
public class AddListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListServiceImpl listService = new ListServiceImpl();
        HttpSession httpSession = req.getSession(false);

        Integer idUser = (Integer) httpSession.getAttribute("id");
        String newListName = req.getParameter("listName");

        listService.createList(idUser, newListName);

        resp.sendRedirect(req.getContextPath() + "/homePage");
    }
}
