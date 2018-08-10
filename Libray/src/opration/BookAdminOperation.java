package opration;

import DAO.ConnectionHelper;
import domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class BookAdminOperation {
    ConnectionHelper helper; //自定义数据库连接对象

    public BookAdminOperation() {
        helper = new ConnectionHelper();
        helper.checkAndInit();
    }

    //关闭连接
    public void closeConnection() {
        helper.closeConnection();
    }

    /* 获取所有图书管理员信息
     * @return 返回结果可能为空,但不是null*/
    public Vector<BookAdmin> getAllBookAdmin() {
        Vector<BookAdmin> BookAdmins = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BookAdmin");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                BookAdmins.add(BookAdmin.CreateBookAdmin(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return BookAdmins;
        }

    }
    //根据图书管理员ID获取其所有信息
    public Vector<BookAdmin> getAdInfo(String AdId){
        Vector<BookAdmin> BookAdmins = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BookAdmin where AdId=?");
            ps.setString(1,AdId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                BookAdmins.add(BookAdmin.CreateBookAdmin(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return BookAdmins;
        }
    }

    /*借书功能的实现,验证UserId和BookId*/
    public boolean adBorrowCheck(String UserId, String BookId) {
        Useroperation useroperation = new Useroperation();
        BookInfoOperation bookInfoOperation = new BookInfoOperation();
        Vector<User> allUser = useroperation.getAllUser();
        Vector<BookInfo> allBook = bookInfoOperation.getAllBookInfo();
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < allUser.size(); i++) {

            if (allUser.get(i).getUserId().equals(UserId)) {
                Vector<UserInfo> userInfos = useroperation.USerInfoSearch(UserId);
                if (userInfos.get(0).getLendedNum() < userInfos.get(0).getMax()) {
                    flag1 = true;
                    useroperation.closeConnection();
                    break;
                }
            }
        }
        for (int j = 0; j < allBook.size(); j++) {
            if (allBook.get(j).getBookId().equals(BookId)) {
                Vector<BookInfo> bookInfos = bookInfoOperation.getBookInfo(BookId);
                if (bookInfos.get(0).getState() == 1) {
                    flag2 = true;
                    bookInfoOperation.closeConnection();
                    break;
                }
            }
        }
        if (flag1 && flag2) {
            flag = true;
        }
        return flag;
    }

    //借书功能的实现,如果验证通过，返回图书的信息至界面
    public Vector<BookInfo> adBorrowgetBookInfo(String BookId) {
        BookInfoOperation bookInfoOperation = new BookInfoOperation();
        Vector<BookInfo> bookInfo = bookInfoOperation.getBookInfo(BookId);
        bookInfoOperation.closeConnection();
        return bookInfo;
    }

    //验证通过之后，将借阅信息插入到借阅记录中,
    // 并修改User表里面在借计数和BookInfo表的图书状态
    public boolean adBorrow(String UserId, String BookId) {
        BookInfoOperation bookInfoOperation = new BookInfoOperation();
        BorrowRecordOperation borrowRecordOperation = new BorrowRecordOperation();
        Vector<BookInfo> bookInfo = bookInfoOperation.getBookInfo(BookId);
        Vector<BorrowRecord> allRecord = borrowRecordOperation.getAllBorrowRecord();
        bookInfoOperation.closeConnection();
        borrowRecordOperation.closeConnection();
        String len = allRecord.get(allRecord.size() - 1).getBorrowID();
        //System.out.println(len);
        int borrowidold = (Integer.parseInt(len));
        String borrowid = String.valueOf(borrowidold + 1);
        //System.out.println(borrowid);

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
       // System.out.println(s.format(date));
        String BorrowTime = s.format(date);//当前的时间

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 30);//计算30天后的时间
        String ShouldTime = s.format(c.getTime());
        //System.out.println("30天后的时间是：" + ShouldTime);


        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("INSERT INTO BorrowRecords VALUE(?,?,?,?,?,?,?,?)");
            ps.setString(1, borrowid);
            ps.setString(2, UserId);
            ps.setString(3, bookInfo.get(0).getBookId());
            ps.setString(4, bookInfo.get(0).getBookName());
            ps.setString(5, BorrowTime);//借书时间
            ps.setString(6, ShouldTime);//预还书时间
            ps.setString(7, null);//实际归还时间
            ps.setInt(8, 0);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            //更改User表和BookInfo表
            Useroperation useroperation = new Useroperation();
            BookInfoOperation bookInfoOperation1 = new BookInfoOperation();
            useroperation.borrowUpdateUserInfo(UserId);
            bookInfoOperation1.borrowUpdateBookInfo(BookId);
            useroperation.closeConnection();
            bookInfoOperation1.closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("增加借阅记录失败!");
            return false;
        }
    }

    //还书操作
    public boolean adReturnBook(String BookId) {
        BorrowRecordOperation borrowRecordOperation = new BorrowRecordOperation();
        Vector<BorrowRecord> records = borrowRecordOperation.getBorrowedByBookId(BookId);
        borrowRecordOperation.closeConnection();
        String UserId = records.get(0).getUserId();

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        //System.out.println(s.format(date));
        String ReturnTime = s.format(date);//当前的时间

        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update BorrowRecords set ReturnTime=?,State=? where BookId=?");
            ps.setString(1, ReturnTime);
            ps.setInt(2, 1);
            ps.setString(3, BookId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            //更改User表和BookInfo表
            Useroperation useroperation = new Useroperation();
            BookInfoOperation bookInfoOperation1 = new BookInfoOperation();
            useroperation.returnUpdateUserInfo(UserId);
            bookInfoOperation1.returnUpdateBookInfo(BookId);
            useroperation.closeConnection();
            bookInfoOperation1.closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("还书失败!");
            return false;
        }
    }

    //新书入库，手动输入
    public boolean addBook(String BookId, String BookName, String Author, String Translator, Float Price, String ISBNCode, String ComeUpTime, String PublishCompany, String EnteringMen) {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        //System.out.println(s.format(date));
        String EnteringDate = s.format(date);//当前的时间

        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("INSERT INTO BookInfo VALUE(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, BookId);
            ps.setString(2, BookName);
            ps.setString(3, Author);
            ps.setString(4, Translator);
            ps.setFloat(5, Price);
            ps.setString(6, ISBNCode);
            ps.setString(7, ComeUpTime);
            ps.setString(8, PublishCompany);
            ps.setInt(9, 1);
            ps.setString(10, EnteringMen);
            ps.setString(11,EnteringDate );
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("入库图书信息失败!");
            return false;
        }
    }
    //图书出库之前，检测图书状态
    public  boolean outBookCheck(String BookId){
        BookInfoOperation bookInfoOperation =new BookInfoOperation();
        Vector<BookInfo>  bookInfo =bookInfoOperation.getBookInfo(BookId);
        bookInfoOperation.closeConnection();
        boolean flag=false;
        if (bookInfo.get(0).getState() == 1)
        {
            flag =true;//表明该图书当前在库
        }
        return flag;
    }
    //图书出库
    public boolean outBook(String BookId){
        PreparedStatement ps ;
        try {
            ps = helper.getPreparedStatement("delete from BookInfo where BookId=?;");
            ps.setString(1, BookId);
            ps.execute();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除图书信息失败!");
            return false;
        }
    }
    //修改图书信息
    public boolean alterBook(String BookId, String BookName, String Author, String Translator, Float Price, String ISBNCode, String ComeUpTime, String PublishCompany, String EnteringMen){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement(" update BookInfo set BookName=?,Author=?,Translator=?,Price=?,ISBNCode=?,ComeUpTime=?,PublishCompany=?,EnteringMen=? where BookId=?");
            ps.setString(1, BookName);
            ps.setString(2, Author);
            ps.setString(3, Translator);
            ps.setFloat(4, Price);
            ps.setString(5, ISBNCode);
            ps.setString(6, ComeUpTime);
            ps.setString(7, PublishCompany);
            ps.setString(8, EnteringMen);
            ps.setString(9,BookId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新图书信息失败!");
            return false;
        }
    }
    //根据图书编号/图书名/借阅号查询借阅记录
    public  Vector<BorrowRecord> getRecord(String search){
        Vector<BorrowRecord> borrowRecords = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BorrowRecords where BookName like '%" + search + "%' or BookId like '%" + search + "%' or UserId like '%" + search + "%'");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                borrowRecords.add(BorrowRecord.CreateBorrowRecord(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return borrowRecords;
        }

    }
    //修改管理员个人信息
    public boolean AlterPersonal(String AdId,String AdPassword,String AdPhone,String AdEmail){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update BookAdmin set AdPassword=?,AdPhone=?,AdEmail=? where AdId=?");
            ps.setString(1, AdPassword);
            ps.setString(2, AdPhone);
            ps.setString(3, AdEmail);
            ps.setString(4, AdId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改管理员信息失败!");
            return false;
        }
    }

}
