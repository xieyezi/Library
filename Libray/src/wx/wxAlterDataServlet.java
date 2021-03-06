package wx;

import com.alibaba.fastjson.JSON;
import domain.UserInfo;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxAlterDataServlet")
public class wxAlterDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userId = request.getParameter("userId");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        boolean flag=false;
        Vector<UserInfo> userInfo = null;
        Useroperation useroperation =new Useroperation();
        flag  = useroperation.AlterData(userId,phone,email);
        if (flag){
            userInfo = useroperation.USerInfoSearchById(userId);
        }
        useroperation.closeConnection();
        String JsonStr = JSON.toJSONString(userInfo);
        response.getWriter().println(JsonStr);
    }
}
