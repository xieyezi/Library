package com.xieyezi;

import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminOutReaderServlet")
public class AdminOutReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId =request.getParameter("id");
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        boolean flag =systemAdOperation.outReaderCheck(UserId);
        systemAdOperation.closeConnection();
        if (flag){
            systemAdOperation.outReaderForUser(UserId);
            systemAdOperation.outReaderForUserInfo(UserId);
            systemAdOperation.closeConnection();
            response.sendRedirect("adminOutReader.jsp?out=yes");
        }
        else {
            systemAdOperation.closeConnection();
            response.sendRedirect("adminOutReader.jsp?check=no");
        }
    }
}
