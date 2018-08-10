package com.xieyezi;

import opration.BookAdminOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdAlterBookServlet")
public class AdAlterBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String BookId =request.getParameter("id");//图书ID
        String BookName=request.getParameter("BookName");//图书名称
        String Author=request.getParameter("Author");//作者
        String Translator=request.getParameter("Translator");//译者
        Float Price= Float.parseFloat(request.getParameter("Price")) ;//价格
        String ISBNCode=request.getParameter("ISBNCode");//ISBN编码
        String ComeUpTime=request.getParameter("ComeUpTime");//出版日期
        String PublishCompany=request.getParameter("PublishCompany");//出版社
        String EnteringMen=request.getParameter("EnteringMen");//入库者
        BookAdminOperation bookAdminOperation =new BookAdminOperation();
        boolean flag =bookAdminOperation.outBookCheck(BookId);
        if (flag){
            bookAdminOperation.alterBook(BookId,BookName,Author,Translator,Price,ISBNCode,ComeUpTime,PublishCompany,EnteringMen);
            bookAdminOperation.closeConnection();
            response.sendRedirect("adAlterBook.jsp?alter=yes");
        }
        else {
            bookAdminOperation.closeConnection();
            response.sendRedirect("adAlterBook.jsp?check=no");
        }
    }
}
