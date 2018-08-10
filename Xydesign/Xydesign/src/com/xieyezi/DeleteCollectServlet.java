package com.xieyezi;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCollectServlet")
public class DeleteCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        User user = (User) request.getSession().getAttribute("User");
        int id = user.getId();
        String modelName = request.getParameter("modelname");
        CollectQuery collectQuery = new CollectQuery();
        collectQuery.deleteCollect(id, modelName);
        collectQuery.closeConnection();
        response.sendRedirect("userCenter.jsp");
    }
}