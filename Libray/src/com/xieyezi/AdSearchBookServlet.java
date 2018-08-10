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

@WebServlet("/AdSearchBookServlet")
public class AdSearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search");
        BookInfoOperation bookInfoOperation = new BookInfoOperation();
        Vector<BookInfo> result = bookInfoOperation.getBookInfo(search);
        bookInfoOperation.closeConnection();

        for (int i = 0; result != null && i < result.size(); i++) {
            if (result.get(i).getTranslator() == null ||result.get(i).getTranslator().equals("")) {
                result.get(i).setTranslator("无");
            }
        }
        request.setAttribute("searchresult", result);
        request.getRequestDispatcher("adSearchBook.jsp").forward(request, response);
    }
}
