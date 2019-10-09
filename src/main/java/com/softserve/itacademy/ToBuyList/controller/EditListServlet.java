package com.softserve.itacademy.ToBuyList.controller;

import com.softserve.itacademy.ToBuyList.service.implementations.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editList")
public class EditListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListServiceImpl itemService = new ListServiceImpl();
        Integer idList = Integer.parseInt(req.getParameter("idList"));
        HttpSession httpSession = req.getSession(false);
        Integer idUser = (Integer) httpSession.getAttribute("id");
        String newListName = req.getParameter("newListName");
        itemService.updateList(idList,newListName);
        resp.sendRedirect(req.getContextPath()+"/homePage?idUser="+idUser.toString());
    }
}
