package com.xieyezi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ce) {
            System.out.println(ce);
        }
        try {
            String messageName = request.getParameter("messageName");
            String messsage = request.getParameter("message");
            String messageEmail= request.getParameter("messageEmail");
            if (messsage.equals("")|| messageName.equals("")|| messageEmail.equals("")){
                request.getRequestDispatcher("about.jsp?success=no").forward(request, response);
            }
            String url = "jdbc:mysql://localhost:3306/Xydesign?&characterEncoding=UTF-8";
            String username = "root";
            String pwd = "suyechun";
            Connection con = DriverManager.getConnection(url, username, pwd);
            String sql = "INSERT INTO message VALUE(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,messageName );
            preparedStatement.setString(2, messageEmail);
            preparedStatement.setString(3,messsage );
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            request.getRequestDispatcher("about.jsp?success=yes").forward(request, response);
        } catch (SQLException ce) {
            ce.printStackTrace();
            System.out.println(ce);

        }
    }
}
