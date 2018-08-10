package opration;

import DAO.ConnectionHelper;
import domain.User;
import domain.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Useroperation {
    ConnectionHelper helper; //自定义数据库连接对象

    public Useroperation() {
        helper = new ConnectionHelper();
        helper.checkAndInit();
    }

    //关闭连接
    public void closeConnection() {
        helper.closeConnection();
    }

    /* 获取所有用户信息
     * @return 返回结果可能为空,但不是null*/
    public Vector<User> getAllUser() {
        Vector<User> Users = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from User");
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Users.add(User.CreateUser(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return Users;
        }

    }
    //按照ID从User表里面查询某个用户的所有信息
    public Vector<User> getUserName(String UserId) {
        Vector<User> Users = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from User where UserId=?");
            ps.setString(1,UserId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Users.add(User.CreateUser(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return Users;
        }

    }
    //按照ID从UserInfo表里面查询某个用户的所有信息
    public Vector<UserInfo> USerInfoSearch(String UserId){
        Vector<UserInfo> User = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select * from UserInfo where UserId=?");
            ps.setString(1,UserId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                User.add(UserInfo.CreateUserInfos(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return  User;
        }
    }
    //按照ID从UserInfo表里面查询某个用户的所有信息(包括两张表)
    public Vector<UserInfo> USerInfoSearchById(String UserId){
        Vector<UserInfo> User = new Vector<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = helper.getPreparedStatement("select User.Password,User.UserName,UserInfo.* from User,UserInfo Where User.UserId=UserInfo.UserId and User.UserId=?");
            ps.setString(1,UserId);
            resultSet = ps.executeQuery();
            while (resultSet != null && resultSet.next()) {
                User.add(UserInfo.CreateUserInfos1(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            helper.close(ps, resultSet);
            return  User;
        }
    }
    //根据ID更新读者的电话邮箱信息
    public boolean AlterData(String UserId,String Phone,String Email){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update UserInfo set Phone=?,Email=? where UserId=?");
            ps.setString(1, Phone);
            ps.setString(2, Email);
            ps.setString(3, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改读者信息失败!");
            return false;
        }
    }
    //修改密码
    public boolean AlterPasswd(String UserId,String Password){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update User set Password=?  where UserId=?");
            ps.setString(1, Password);
            ps.setString(2, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改读者密码失败!");
            return false;
        }
    }
    //借书时传入UserId，更改在借数量
    public boolean borrowUpdateUserInfo(String UserId){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update UserInfo set LendedNum=LendedNum+? where UserId =?");
            ps.setInt(1, 1);
            ps.setString(2, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改读者在借数量失败!");
            return false;
        }
    }
    //还书时传入UserId，更改在借数量
    public boolean returnUpdateUserInfo(String UserId){
        PreparedStatement ps;
        try {
            ps = helper.getPreparedStatement("update UserInfo set LendedNum=LendedNum-? where UserId =?");
            ps.setInt(1, 1);
            ps.setString(2, UserId);
            ps.executeUpdate();
            helper.closePreparedStatement(ps);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改读者在借数量失败!");
            return false;
        }
    }
}
