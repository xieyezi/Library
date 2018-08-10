package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfo {
    private String UserId;//用户ID(学号)
    private String Departments;//院系
    private String Major;//专业
    private String Phone;//电话
    private String Email;//邮箱
    private int Max;//可借最大数量
    private int Time;//可借期限
    private int LendedNum;//在借数量
    private String UserName;//读者姓名
    private String Password;//读者密码
    public UserInfo(String UserId,String Departments,String Major,String Phone,String Email,int Max,int Time,int LendedNum){
        this.UserId=UserId;
        this.Departments=Departments;
        this.Major=Major;
        this.Phone=Phone;
        this.Email=Email;
        this.Max=Max;
        this.Time=Time;
        this.LendedNum=LendedNum;
    }
    public UserInfo(String UserId,String UserName,String Password,String Departments,String Major,String Phone,String Email,int Max,int Time,int LendedNum){
        this.UserId=UserId;
        this.UserName=UserName;
        this.Password =Password;
        this.Departments=Departments;
        this.Major=Major;
        this.Phone=Phone;
        this.Email=Email;
        this.Max=Max;
        this.Time=Time;
        this.LendedNum=LendedNum;
    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getDepartments() {
        return Departments;
    }

    public void setDepartments(String departments) {
        Departments = departments;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        Max = max;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public int getLendedNum() {
        return LendedNum;
    }

    public void setLendedNum(int lendedNum) {
        LendedNum = lendedNum;
    }

    public static UserInfo CreateUserInfos(ResultSet resultSet) {
        try {
            String UserId = resultSet.getString("UserId");
            String Departments = resultSet.getString("Departments");
            String Major = resultSet.getString("Major");
            String Phone = resultSet.getString("Phone");
            String Email =resultSet.getString("Email");
            int Max =resultSet.getInt("Max");
            int Time=resultSet.getInt("Time");
            int LendedNum =resultSet.getInt("LendedNum");
            return new UserInfo(UserId,Departments,Major,Phone,Email,Max,Time,LendedNum);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个UserInfo对象失败!");
            return null;
        }
    }
    //系统管理员查询读者信息所用
    public static UserInfo CreateUserInfos1(ResultSet resultSet) {
        try {
            String UserId = resultSet.getString("UserId");
            String UserName = resultSet.getString("UserName");
            String Password = resultSet.getString("Password");
            String Departments = resultSet.getString("Departments");
            String Major = resultSet.getString("Major");
            String Phone = resultSet.getString("Phone");
            String Email =resultSet.getString("Email");
            int Max =resultSet.getInt("Max");
            int Time=resultSet.getInt("Time");
            int LendedNum =resultSet.getInt("LendedNum");
            return new UserInfo(UserId,UserName,Password,Departments,Major,Phone,Email,Max,Time,LendedNum);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个UserInfo对象失败!");
            return null;
        }
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
}
