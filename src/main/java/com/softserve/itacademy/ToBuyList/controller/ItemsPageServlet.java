package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.entity.Item;
import com.softserve.itacademy.ToBuyList.service.implementations.ItemServiceImpl;
import com.softserve.itacademy.ToBuyList.service.interfaces.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/itemPage")
public class ItemsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idList = Integer.parseInt(req.getParameter("idList"));
        ItemServiceImpl itemService = new ItemServiceImpl();
        ArrayList<Item> itemsByList = itemService.getItemsByList(idList);
        req.setAttribute("items", itemsByList);
        req.getRequestDispatcher("webapp/pages/item.jsp").forward(req, resp);
    }
}
