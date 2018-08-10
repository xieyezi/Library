package com.xieyezi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
            String url = "jdbc:mysql://localhost:3306/Xydesign?&characterEncoding=UTF-8";
            String username = "root";
            String pwd = "suyechun";
            Connection con = DriverManager.getConnection(url, username, pwd);
            int countID;
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM users");
            rs.last();
            countID =rs.getRow();
            String sql = "INSERT INTO users VALUE(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, countID+1);
            preparedStatement.setString(2, request.getParameter("username"));
            preparedStatement.setString(3, request.getParameter("password"));
            preparedStatement.setString(4, request.getParameter("phone_number"));
            preparedStatement.setString(5, request.getParameter("email"));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            s.close();
            rs.close();
            con.close();
            request.getRequestDispatcher("login.jsp?regis=yes").forward(request, response);
        } catch (SQLException ce) {
            ce.printStackTrace();
            System.out.println(ce);

        }
    }
}
