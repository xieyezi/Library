package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String UserId;//用户ID(学号)
    private String UserName;//用户名
    private String Password;//用户密码
    public User(String UserId,String UserName,String Password){
        this.UserId=UserId;
        this.UserName=UserName;
        this.Password=Password;
    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public static User CreateUser(ResultSet resultSet) {
        try {
            String UserId = resultSet.getString("UserId");
            String UserName = resultSet.getString("UserName");
            String Password = resultSet.getString("Password");
            return new User(UserId,UserName,Password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个User对象失败!");
            return null;
        }
    }
}
