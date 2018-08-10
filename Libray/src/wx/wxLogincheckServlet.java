package wx;

import com.alibaba.fastjson.JSON;
import domain.BookAdmin;
import domain.SystemAdmin;
import domain.User;
import domain.UserInfo;
import opration.BookAdminOperation;
import opration.SystemAdOperation;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxLogincheckServlet")
public class wxLogincheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userId = request.getParameter("userId");
        String Password = request.getParameter("password");
        String type =request.getParameter("type");
        System.out.println(type);
        if (type.equals("读者")){
            Useroperation useroperation = new Useroperation();
            Vector<User> allUser = useroperation.getAllUser();
            Vector<UserInfo> userInfo = null;

            for (int i = 0; i < allUser.size(); i++) {
                if (userId.equals(allUser.get(i).getUserId()) && Password.equals(allUser.get(i).getPassword())) {
                    userInfo = useroperation.USerInfoSearchById(userId);
                    useroperation.closeConnection();
                    break;
                }
            }
            String JsonStr = JSON.toJSONString(userInfo);
            response.getWriter().println(JsonStr);
        }
        if (type.equals("图书管理员")){
            BookAdminOperation bookAdminOperation =new BookAdminOperation();
            Vector<BookAdmin> allBookAdmin =bookAdminOperation.getAllBookAdmin();
            bookAdminOperation.closeConnection();
            BookAdmin bookAdmin =null;
            for (int i=0;i<allBookAdmin.size();i++){
                if (userId.equals(allBookAdmin.get(i).getAdId()) && Password.equals(allBookAdmin.get(i).getAdPassword())){

                    bookAdmin =new BookAdmin(allBookAdmin.get(i).getAdId(),allBookAdmin.get(i).getAdName(),allBookAdmin.get(i).getAdPassword(),allBookAdmin.get(i).getAdPhone(),allBookAdmin.get(i).getAdEmail());
                    break;
                }
            }
            String JsonStr = JSON.toJSONString(bookAdmin);
            response.getWriter().println(JsonStr);
        }
        if (type.equals("系统管理员")){
            SystemAdOperation systemAdOperation =new SystemAdOperation();
            Vector<SystemAdmin> allSystemAdmin =systemAdOperation.getAllSysAdmin();
            systemAdOperation.closeConnection();
            SystemAdmin systemAdmin =null;
            for (int i=0;i<allSystemAdmin.size();i++){
                if (userId.equals(allSystemAdmin.get(i).getAdminId()) && Password.equals(allSystemAdmin.get(i).getAdminPassword())){
                    systemAdmin =new SystemAdmin(allSystemAdmin.get(i).getAdminId(),allSystemAdmin.get(i).getAdminName(),allSystemAdmin.get(i).getAdminPassword(),allSystemAdmin.get(i).getAdminPhone(),allSystemAdmin.get(i).getAdminEmail());
                    break;
                }
            }
            String JsonStr = JSON.toJSONString(systemAdmin);
            response.getWriter().println(JsonStr);
        }

    }
}
