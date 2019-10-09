package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editItem")
public class EditItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ItemServiceImpl itemService = new ItemServiceImpl();

        Integer idItem = Integer.parseInt(req.getParameter("idItem"));
        Integer idList = Integer.parseInt(req.getParameter("idList"));
        String newItemText = req.getParameter("newItemText");

        itemService.updateItem(idItem, newItemText);

        resp.sendRedirect(req.getContextPath() + "/itemPage?idList=" + idList);
    }
}
