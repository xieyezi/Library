package com.xieyezi;

import domain.BookInfo;
import opration.BookInfoOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/bookCheckServlet")
public class bookCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String BookId =request.getParameter("BookId");
        BookInfoOperation bookInfoOperation =new BookInfoOperation();
        Vector<BookInfo> searchresult= bookInfoOperation.getBookInfo(BookId);
        bookInfoOperation.closeConnection();
        request.setAttribute("searchresult",searchresult);
        request.getRequestDispatcher("adAlterBook.jsp").forward(request,response);
    }
}
