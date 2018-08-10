package com.xieyezi;

import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdBorrowServlet")
public class AdBorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId =request.getParameter("UserId");
        String BookId =request.getParameter("BookId");
//        System.out.println(UserId);
//        System.out.println(BookId);
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        bookAdminOperation.adBorrow(UserId,BookId);
        bookAdminOperation.closeConnection();
        response.sendRedirect("adBorrowBook.jsp?borrow=yes");
    }
}
