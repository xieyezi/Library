package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAdmin {
    private String AdId;//图书管理员ID
    private String AdName;//图书管理员名
    private String AdPassword;//用户密码
    private String AdPhone;//联系电话
    private String AdEmail;//邮箱
    public BookAdmin(String AdId,String AdName,String AdPassword,String AdPhone,String AdEmail){
        this.AdId=AdId;
        this.AdName=AdName;
        this.AdPassword=AdPassword;
        this.AdPhone=AdPhone;
        this.AdEmail=AdEmail;
    }

    public String getAdId() {
        return AdId;
    }

    public void setAdId(String adId) {
        AdId = adId;
    }

    public String getAdName() {
        return AdName;
    }

    public void setAdName(String adName) {
        AdName = adName;
    }

    public String getAdPassword() {
        return AdPassword;
    }

    public void setAdPassword(String adPassword) {
        AdPassword = adPassword;
    }

    public String getAdPhone() {
        return AdPhone;
    }

    public void setAdPhone(String adPhone) {
        AdPhone = adPhone;
    }

    public String getAdEmail() {
        return AdEmail;
    }

    public void setAdEmail(String adEmail) {
        AdEmail = adEmail;
    }

    public static BookAdmin CreateBookAdmin(ResultSet resultSet) {
        try {
            String AdId = resultSet.getString("AdId");
            String AdName = resultSet.getString("AdName");
            String AdPassword = resultSet.getString("AdPassword");
            String AdPhone = resultSet.getString("AdPhone");
            String AdEmail = resultSet.getString("AdEmail");
            return new BookAdmin(AdId,AdName,AdPassword,AdPhone,AdEmail);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个BookAdmin对象失败!");
            return null;
        }
    }
}
