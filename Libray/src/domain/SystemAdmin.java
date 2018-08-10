package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemAdmin {
    private  String AdminId;//系统管理员ID
    private  String AdminName;//系统管理员名
    private  String AdminPassword;//用户密码
    private  String AdminPhone;//联系电话
    private  String AdminEmail;//邮箱
    public  SystemAdmin(String AdminId,String AdminName,String AdminPassword,String AdminPhone,String AdminEmail){
        this.AdminId=AdminId;
        this.AdminName =AdminName;
        this.AdminPassword =AdminPassword;
        this.AdminPhone=AdminPhone;
        this.AdminEmail=AdminEmail;
    }
    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return AdminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        AdminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        AdminEmail = adminEmail;
    }

    public static SystemAdmin CreateSysAdmin(ResultSet resultSet) {
        try {
            String AdminId = resultSet.getString("AdminId");
            String AdminName = resultSet.getString("AdminName");
            String AdminPassword = resultSet.getString("AdminPassword");
            String AdminPhone = resultSet.getString("AdminPhone");
            String AdminEmail = resultSet.getString("AdminEmail");
            return new SystemAdmin(AdminId,AdminName,AdminPassword,AdminPhone,AdminEmail);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个SystemAdmin对象失败!");
            return null;
        }
    }
}
