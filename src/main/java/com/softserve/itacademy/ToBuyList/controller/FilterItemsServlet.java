package com.softserve.itacademy.ToBuyList.controller;

import com.google.gson.Gson;
import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.service.implementations.ItemServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/filterItems")
public class FilterItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ItemServiceImpl itemService = new ItemServiceImpl();

        Integer idList = Integer.parseInt(req.getParameter("idList"));
        String criterion = req.getParameter("criterion");

        ArrayList<Item> requestedItems = itemService.filter(criterion, idList);
        String json = new Gson().toJson(requestedItems);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
