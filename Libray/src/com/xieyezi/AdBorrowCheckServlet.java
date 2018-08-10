package com.xieyezi;

import domain.BookInfo;
import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/AdBorrowCheckServlet")
public class AdBorrowCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String UserId=request.getParameter("UserId");
        String BookId = request.getParameter("BookId");
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        boolean flag =bookAdminOperation.adBorrowCheck(UserId,BookId);
        bookAdminOperation.closeConnection();
//        System.out.println(flag);
        if (flag){
//            System.out.println(flag);
            Vector<BookInfo> bookInfo =bookAdminOperation.adBorrowgetBookInfo(BookId);
            request.setAttribute("bookInfo",bookInfo);
            request.setAttribute("UserId",UserId);
            request.getRequestDispatcher("adBorrowBook.jsp").forward(request,response);
        }
        else {

              response.sendRedirect("adBorrowBook.jsp?check=no");
        }
    }
}
