package com.xieyezi;


import domain.BorrowRecord;
import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/AdCheckBookServlet")
public class AdCheckBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search");
        BookAdminOperation bookAdminOperation = new BookAdminOperation();
        Vector<BorrowRecord> result = bookAdminOperation.getRecord(search);
        bookAdminOperation.closeConnection();

        for (int i = 0; result != null && i < result.size(); i++){
            if (result.get(i).getReturnTime() ==null){
                result.get(i).setReturnTime("在借状态");
            }
        }
        request.setAttribute("searchresult", result);
        request.getRequestDispatcher("adCheckBook.jsp").forward(request, response);
    }
}
