package com.xieyezi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "CollectServlet")
public class CollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String modelID = (String) request.getParameter("modelID");
        int userID =Integer.parseInt(request.getParameter("id"));
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
            String sql = "INSERT INTO collect VALUE(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, modelID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            request.getRequestDispatcher("getdetail.jsp?collect=yes&imgURL="+modelID).forward(request, response);
        } catch (SQLException ce) {
            ce.printStackTrace();
            System.out.println(ce);

        }
    }
}
