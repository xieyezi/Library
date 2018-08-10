package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRecord {
    private String BorrowID;//借阅记录ID
    private String UserId;//用户ID
    private String BookId;//图书ID
    private String BookName;//书名
    private String BorrowTime;//借书时间
    private String ShouldTime;//预还书时间
    private String ReturnTime;//实际还书时间
    private int State;//借阅状态

    public BorrowRecord (String BorrowID,String UserId,String BookId,String BookName,String BorrowTime,String ShouldTime,String ReturnTime,int State){
        this.BorrowID=BorrowID;
        this.UserId=UserId;
        this.BookId=BookId;
        this.BookName=BookName;
        this.BorrowTime=BorrowTime;
        this.ShouldTime=ShouldTime;
        this.ReturnTime=ReturnTime;
        this.State=State;
    }

    public String getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(String borrowID) {
        BorrowID = borrowID;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBorrowTime() {
        return BorrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        BorrowTime = borrowTime;
    }

    public String getShouldTime() {
        return ShouldTime;
    }

    public void setShouldTime(String shouldTime) {
        ShouldTime = shouldTime;
    }

    public String getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(String returnTime) {
        ReturnTime = returnTime;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
    //返回一个BorrowRecord对象
    public static BorrowRecord CreateBorrowRecord(ResultSet resultSet) {
        try {
            String BorrowID=resultSet.getString("BorrowID");
            String UserId=resultSet.getString("UserId");
            String BookId=resultSet.getString("BookId");
            String BookName=resultSet.getString("BookName");
            String BorrowTime=resultSet.getString("BorrowTime");
            String ShouldTime=resultSet.getString("ShouldTime");
            String ReturnTime=resultSet.getString("ReturnTime");
            int State=resultSet.getInt("State");
            return new BorrowRecord(BorrowID,UserId,BookId,BookName,BorrowTime,ShouldTime,ReturnTime,State);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个BorrowRecord对象失败!");
            return null;
        }
    }
}
