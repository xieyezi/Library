package opration;

import DAO.ConnectionHelper;
import domain.BookInfo;
import domain.BorrowRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BorrowRecordOperation {
    ConnectionHelper helper; //自定义数据库连接对象

    public BorrowRecordOperation() {
        helper = new ConnectionHelper();
        helper.checkAndInit();
    }

    //关闭连接
    public void closeConnection() {
        helper.closeConnection();
    }


    //查询所有借阅记录
    public Vector<BorrowRecord> getAllBorrowRecord() {
        Vector<BorrowRecord> allrecord = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BorrowRecords");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                allrecord.add(BorrowRecord.CreateBorrowRecord(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return allrecord;
        }

    }

    //根据读者的ID查询在借记录
    public Vector<BorrowRecord> getBorrowing(String UserId) {
        Vector<BorrowRecord> records = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BorrowRecords where UserId=? and State=0");
            ps.setString(1,UserId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                records.add(BorrowRecord.CreateBorrowRecord(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return records;
        }

    }
    //根据读者的ID查询借阅记录
    public Vector<BorrowRecord> getBorrowed(String UserId) {
        Vector<BorrowRecord> records = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BorrowRecords where UserId=? and State=1");
            ps.setString(1,UserId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                records.add(BorrowRecord.CreateBorrowRecord(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return records;
        }

    }
    //根据图书ID查询借阅记录
    public Vector<BorrowRecord> getBorrowedByBookId(String BookId) {
        Vector<BorrowRecord> records = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BorrowRecords where BookId=?");
            ps.setString(1,BookId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                records.add(BorrowRecord.CreateBorrowRecord(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return records;
        }

    }
}
