package com.xieyezi;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String Id = request.getParameter("username");
        String Pwd = request.getParameter("password");
        int flag =0;
        String id ="";
        //连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ce){
            System.out.println(ce);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/Xydesign";
            String username= "root";
            String pwd = "suyechun";
            Connection con = DriverManager.getConnection(url,username,pwd);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select username,password,id from users ");
            String name;
            String pawd;
            while (rs.next()) {
                name=rs.getString("username");
                pawd =rs.getString("password");

                if (Id.equals(name)&&Pwd.equals(pawd)){
                    flag=1;
                    User user = new User();
                    user.setUsername(Id);
                    user.setPassword(Pwd);
                    user.setId(rs.getInt("id"));
                    HttpSession session = request.getSession();
                    session.setAttribute("User",user);
                    break;
                }
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException ce) {
            System.out.println(ce);

        }
        if (flag==1){
            response.sendRedirect("userCenter.jsp");
        }
        else {
            response.sendRedirect("login.jsp?login=yes");
        }
    }
}
