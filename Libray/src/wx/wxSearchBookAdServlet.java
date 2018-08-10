package wx;

import com.alibaba.fastjson.JSON;
import domain.BookAdmin;
import opration.SystemAdOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxSearchBookAdServlet")
public class wxSearchBookAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search =request.getParameter("search");
        Vector<BookAdmin> bookAdmins =null;
        SystemAdOperation systemAdOperation =new SystemAdOperation();
        bookAdmins=systemAdOperation.queryAd(search);
        systemAdOperation.closeConnection();
        String JsonStr = JSON.toJSONString(bookAdmins);
        response.getWriter().println(JsonStr);
    }
}
