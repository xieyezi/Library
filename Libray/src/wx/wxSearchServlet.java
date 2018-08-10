package wx;

import com.alibaba.fastjson.JSON;
import domain.BookInfo;
import opration.BookInfoOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxSearchServlet")
public class wxSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String search =request.getParameter("search");
        Vector<BookInfo> bookInfos=null;
        BookInfoOperation operation =new BookInfoOperation();
        bookInfos=operation.getBookInfo(search);
        operation.closeConnection();
        String JsonStr = JSON.toJSONString(bookInfos);
        response.getWriter().println(JsonStr);
    }
}
