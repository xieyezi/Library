package wx;

import com.alibaba.fastjson.JSON;
import domain.User;
import domain.UserInfo;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxSearchReaderServlet")
public class wxSearchReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search =request.getParameter("search");
        Useroperation useroperation = new Useroperation();
        Vector<UserInfo> userInfo = null;
        userInfo = useroperation.USerInfoSearchById(search);
        useroperation.closeConnection();
        String JsonStr = JSON.toJSONString(userInfo);
        response.getWriter().println(JsonStr);
    }
}
