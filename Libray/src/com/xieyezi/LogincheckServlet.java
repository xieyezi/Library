package com.xieyezi;

import domain.BookAdmin;
import domain.SystemAdmin;
import domain.User;
import opration.BookAdminOperation;
import opration.SystemAdOperation;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/LogincheckServlet")
public class LogincheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String type=request.getParameter("Type");
        String name=request.getParameter("name");
        String password =request.getParameter("password");
        int flag =0;
        User user=null;
        BookAdmin bookAdmin =null;
        SystemAdmin systemAdmin =null;
        //为读者
        if (type.equals("option1")){
            Useroperation useroperation =new Useroperation();
            Vector<User> allUser =useroperation.getAllUser();
            useroperation.closeConnection();
            for (int i=0;i<allUser.size();i++){
                if (name.equals(allUser.get(i).getUserId()) && password.equals(allUser.get(i).getPassword())){
                    flag=1;
                    user = new User(allUser.get(i).getUserId(),allUser.get(i).getUserName(),allUser.get(i).getPassword());
                    break;
                }
            }
            if (flag==1){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                request.getRequestDispatcher("readerPersonal.jsp").forward(request,response);
            }
            else {
                response.sendRedirect("login.jsp?login=no");
            }

        }
        //为图书管理员
        else if (type.equals("option2")){
            BookAdminOperation bookAdminOperation =new BookAdminOperation();
            Vector<BookAdmin> allBookAdmin =bookAdminOperation.getAllBookAdmin();
            bookAdminOperation.closeConnection();
            for (int i=0;i<allBookAdmin.size();i++){
                if (name.equals(allBookAdmin.get(i).getAdId()) && password.equals(allBookAdmin.get(i).getAdPassword())){
                    flag=1;
                    bookAdmin =new BookAdmin(allBookAdmin.get(i).getAdId(),allBookAdmin.get(i).getAdName(),allBookAdmin.get(i).getAdPassword(),allBookAdmin.get(i).getAdPhone(),allBookAdmin.get(i).getAdEmail());
                    break;
                }
            }
            if (flag==1){
                HttpSession session = request.getSession();
                session.setAttribute("bookadmin",bookAdmin);
                request.getRequestDispatcher("adBorrowBook.jsp").forward(request,response);
            }
            else {
                response.sendRedirect("login.jsp?login=no");
            }

        }
        //为系统管理员
        else if (type.equals("option3")){
            SystemAdOperation systemAdOperation =new SystemAdOperation();
            Vector<SystemAdmin> allSystemAdmin =systemAdOperation.getAllSysAdmin();
            systemAdOperation.closeConnection();
            for (int i=0;i<allSystemAdmin.size();i++){
                if (name.equals(allSystemAdmin.get(i).getAdminId()) && password.equals(allSystemAdmin.get(i).getAdminPassword())){
                    flag=1;
                    systemAdmin =new SystemAdmin(allSystemAdmin.get(i).getAdminId(),allSystemAdmin.get(i).getAdminName(),allSystemAdmin.get(i).getAdminPassword(),allSystemAdmin.get(i).getAdminPhone(),allSystemAdmin.get(i).getAdminEmail());
                    break;
                }
            }
            if (flag==1){
                HttpSession session = request.getSession();
                session.setAttribute("sysadmin",systemAdmin);
                request.getRequestDispatcher("adminAddReader.jsp").forward(request,response);

            }
            else {
                response.sendRedirect("login.jsp?login=no");
            }


        }
    }
}
