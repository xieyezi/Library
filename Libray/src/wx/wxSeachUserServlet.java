package wx;

import com.alibaba.fastjson.JSON;
import domain.UserInfo;
import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxSeachUserServlet")
public class wxSeachUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search =request.getParameter("search");
        Vector<UserInfo> userInfos=null;
        SystemAdOperation systemAdOperation=new SystemAdOperation();
        userInfos=systemAdOperation.queryReader(search);
        systemAdOperation.closeConnection();
        String JsonStr = JSON.toJSONString(userInfos);
        response.getWriter().println(JsonStr);
    }
}
