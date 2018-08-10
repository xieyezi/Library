package opration;

import DAO.ConnectionHelper;
import domain.BookInfo;
import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BookInfoOperation {
    ConnectionHelper helper; //自定义数据库连接对象

    public BookInfoOperation() {
        helper = new ConnectionHelper();
        helper.checkAndInit();
    }

    //关闭连接
    public void closeConnection() {
        helper.closeConnection();
    }

    //根据书名或者图书ID或作者实现模糊查询
    public Vector<BookInfo> getBookInfo(String search) {
        Vector<BookInfo> bookInfos = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BookInfo where BookName like '%" + search + "%' or BookId like '%" + search + "%' or Author like '%" + search + "%'");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                bookInfos.add(BookInfo.CreateBookInfo(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return bookInfos;
        }

    }

    //查询所有图书信息
    public Vector<BookInfo> getAllBookInfo() {
        Vector<BookInfo> allBook = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BookInfo");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                allBook.add(BookInfo.CreateBookInfo(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return allBook;
        }

    }

    //借书时传入BookId，更改图书借阅状态
    public boolean borrowUpdateBookInfo(String BookId) {
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update BookInfo set State=? where BookId =?");
            ps.setInt(1, 0);
            ps.setString(2, BookId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改图书借阅状态失败!");
            return false;
        }
    }

    //还书时传入BookId，更改图书借阅状态
    public boolean returnUpdateBookInfo(String BookId) {
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update BookInfo set State=? where BookId =?");
            ps.setInt(1, 1);
            ps.setString(2, BookId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改图书借阅状态失败!");
            return false;
        }
    }
}
