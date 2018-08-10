package wx;

import com.alibaba.fastjson.JSON;
import domain.BorrowRecord;
import domain.UserInfo;
import opration.BorrowRecordOperation;
import opration.Useroperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wxReaderBorrowServlet")
public class wxReaderBorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userId = request.getParameter("userId");
        boolean flag=false;
        Vector<BorrowRecord> records = null;
        BorrowRecordOperation borrowRecordOperation =new BorrowRecordOperation();
        records=borrowRecordOperation.getBorrowing(userId);
        borrowRecordOperation.closeConnection();
        String JsonStr = JSON.toJSONString(records);
        response.getWriter().println(JsonStr);
    }
}
