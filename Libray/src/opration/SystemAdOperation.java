package opration;

import DAO.ConnectionHelper;
import domain.BookAdmin;
import domain.SystemAdmin;
import domain.User;
import domain.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class SystemAdOperation {
    ConnectionHelper helper; //自定义数据库连接对象

    public SystemAdOperation() {
        helper = new ConnectionHelper();
        helper.checkAndInit();
    }

    //关闭连接
    public void closeConnection() {
        helper.closeConnection();
    }

    /* 获取所有系统管理员信息
     * @return 返回结果可能为空,但不是null*/
    public Vector<SystemAdmin> getAllSysAdmin() {
        Vector<SystemAdmin> SystemAdmins = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from SystemAdmin");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                SystemAdmins.add(SystemAdmin.CreateSysAdmin(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return SystemAdmins;
        }

    }
    //录入新读者到User表
    public  boolean addReaderToUser(String UserId,String UserName,String Password){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("INSERT INTO User VALUE(?,?,?)");
            ps.setString(1, UserId);
            ps.setString(2, UserName);
            ps.setString(3, Password);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("新增读者失败!");
            return false;
        }
    }
    //录入新读者到UserInfo表
    public  boolean addReaderToUserInfo(String UserId,String Departments,String Major,String Phone,String Email,int Max,int Time,int LendedNum){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("INSERT INTO UserInfo VALUE(?,?,?,?,?,?,?,?)");
            ps.setString(1, UserId);
            ps.setString(2, Departments);
            ps.setString(3, Major);
            ps.setString(4, Phone);
            ps.setString(5, Email);
            ps.setInt(6, Max);
            ps.setInt(7, Time);
            ps.setInt(8, LendedNum);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("新增读者失败!");
            return false;
        }
    }
    //录入新的图书管理员
    public boolean addAd(String AdId,String AdName,String AdPassword,String AdPhone,String AdEmail){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("INSERT INTO BookAdmin VALUE(?,?,?,?,?)");
            ps.setString(1, AdId);
            ps.setString(2, AdName);
            ps.setString(3, AdPassword);
            ps.setString(4, AdPhone);
            ps.setString(5, AdEmail);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("新增读者失败!");
            return false;
        }
    }
    //删除读者时先进行检查，如果有当前有借阅记录，则不能删除
    public boolean outReaderCheck(String UserId){
        boolean flag =false;
        Useroperation useroperation =new Useroperation();
        Vector<UserInfo> userInfo = useroperation.USerInfoSearch(UserId);
        useroperation.closeConnection();
        if (userInfo.get(0).getLendedNum() ==0){
            flag=true;
        }
        return flag;
    }
    //从User表删除读者
    public  boolean outReaderForUser(String UserId){
        PreparedStatement ps ;
        try {
            ps = helper.getPreparedStatement("delete from User where UserId=?;");
            ps.setString(1, UserId);
            ps.execute();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除读者失败!");
            return false;
        }
    }
    //从UserInfo表删除读者
    public boolean outReaderForUserInfo(String UserId){
        PreparedStatement ps ;
        try {
            ps = helper.getPreparedStatement("delete from UserInfo where BookId=?;");
            ps.setString(1, UserId);
            ps.execute();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除读者失败!");
            return false;
        }
    }
    //修改User表里面的信息
    public  boolean AlterForUser(String UserId,String UserName,String Password){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement(" update User set UserName=?,Password=? where UserId=?");
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.setString(3, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新读者信息失败!");
            return false;
        }
    }
    //修改UserInfo表里面的信息
    public  boolean AlterForUserInfo(String UserId,String Departments,String Major,String Phone,String Email){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement(" update UserInfo set Departments=?,Major=?,Phone=?,Email=? where UserId=?");
            ps.setString(1, Departments);
            ps.setString(2, Major);
            ps.setString(3, Phone);
            ps.setString(4, Email);
            ps.setString(5, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新读者信息失败!");
            return false;
        }
    }
    //删除图书管理员
    public boolean outAd(String AdId){
        PreparedStatement ps ;
        try {
            ps = helper.getPreparedStatement("delete from BookAdmin where AdId=?;");
            ps.setString(1, AdId);
            ps.execute();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除图书管理员失败!");
            return false;
        }
    }
    //修改图书管理员信息
    public boolean alterAd(String AdId,String AdName,String AdPassword, String AdPhone,String AdEmail){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement(" update BookAdmin set AdName=?,AdPassword=?,AdPhone=?,AdEmail=? where AdId=?");
            ps.setString(1, AdName);
            ps.setString(2, AdPassword);
            ps.setString(3, AdPhone);
            ps.setString(4, AdEmail);
            ps.setString(5, AdId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新图书管理员信息失败!");
            return false;
        }
    }
    //查询读者信息,可以根据姓名，学号，学院，系进行查询
    public Vector<UserInfo> queryReader(String search){
        Vector<UserInfo> userInfos = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from User,UserInfo Where User.UserId=UserInfo.UserId and User.UserId='"+search+
                                             "'union select * from User,UserInfo Where User.UserId=UserInfo.UserId and User.UserName='"+search+
                                             "'union select * from User,UserInfo Where User.UserId=UserInfo.UserId and UserInfo.Departments='"+search+
                                             "'union select * from User,UserInfo Where User.UserId=UserInfo.UserId and UserInfo.Major='"+search+"'");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                userInfos.add(UserInfo.CreateUserInfos1(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return userInfos;
        }
    }
    //查询图书管理员信息，可以根据ID，姓名
    public Vector<BookAdmin> queryAd(String search){
        Vector<BookAdmin> BookAdmins = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from BookAdmin where AdId=? or AdName=?");
            ps.setString(1,search);
            ps.setString(2,search);
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
    //更新系统管理员信息
    public boolean changeAdmin(String AdminId,String AdminPassword,String AdminPhone,String AdminEmail){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update SystemAdmin set AdminPassword=?,AdminPhone=?,AdminEmail=? where AdminId=?");
            ps.setString(1, AdminPassword);
            ps.setString(2, AdminPhone);
            ps.setString(3, AdminEmail);
            ps.setString(4, AdminId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改系统管理员信息失败!");
            return false;
        }
    }
}
