package com.softserve.itacademy.ToBuyList.controller;

import com.google.gson.Gson;
import com.softserve.itacademy.ToBuyList.entity.List;
import com.softserve.itacademy.ToBuyList.service.implementations.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/filterLists")
public class FilterListsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ListServiceImpl listService = new ListServiceImpl();
        HttpSession httpSession = req.getSession(false);

        String criterion = req.getParameter("criterion");
        Integer idUser = (Integer) httpSession.getAttribute("id");

        ArrayList<List> requestedLists = listService.filter(criterion, idUser);
        String json = new Gson().toJson(requestedLists);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
