package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeItemDone")
public class ChangeItemDoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemServiceImpl itemService = new ItemServiceImpl();

        Integer idItem = Integer.parseInt(req.getParameter("idItem"));

        itemService.changeDoneById(idItem);
    }
}
