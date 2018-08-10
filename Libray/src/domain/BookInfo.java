package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfo {
    private String BookId;//图书ID
    private String BookName;//图书名称
    private String Author;//作者
    private String Translator;//译者
    private Float Price;//价格
    private String ISBNCode;//ISBN编码
    private String ComeUpTime;//出版日期
    private String PublishCompany;//出版社
    private int State;//图书状态
    private String EnteringMen;//入库者
    private String EnteringDate;//入库日期

    public BookInfo(String BookId,String BookName,String Author,String Translator,Float Price,String ISBNCode,String ComeUpTime,String PublishCompany,int State,String EnteringMen,String EnteringDate){
        this.BookId =BookId;
        this.BookName=BookName;
        this.Author =Author;
        this.Translator =Translator;
        this.Price =Price;
        this.ISBNCode =ISBNCode;
        this.ComeUpTime =ComeUpTime;
        this.PublishCompany =PublishCompany;
        this.State=State;
        this.EnteringMen = EnteringMen;
        this.EnteringDate =EnteringDate;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTranslator() {
        return Translator;
    }

    public void setTranslator(String translator) {
        Translator = translator;
    }



    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public String getComeUpTime() {
        return ComeUpTime;
    }

    public void setComeUpTime(String comeUpTime) {
        ComeUpTime = comeUpTime;
    }

    public String getPublishCompany() {
        return PublishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        PublishCompany = publishCompany;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getEnteringMen() {
        return EnteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        EnteringMen = enteringMen;
    }

    public String getEnteringDate() {
        return EnteringDate;
    }

    public void setEnteringDate(String enteringDate) {
        EnteringDate = enteringDate;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }
    //返回一个BookInfo对象
    public static BookInfo CreateBookInfo(ResultSet resultSet) {
        try {
           String BookId=resultSet.getString("BookId");//图书ID
           String BookName=resultSet.getString("BookName");//图书名称
            String Author=resultSet.getString("Author");//作者
            String Translator=resultSet.getString("Translator");//译者
            Float Price=resultSet.getFloat("Price");//价格
            String ISBNCode=resultSet.getString("ISBNCode");//ISBN编码
            String ComeUpTime=resultSet.getString("ComeUpTime");//出版日期
            String PublishCompany=resultSet.getString("PublishCompany");//出版社
            int State=resultSet.getInt("State");//图书状态
            String EnteringMen=resultSet.getString("EnteringMen");//入库者
            String EnteringDate=resultSet.getString("EnteringDate");//入库日期
            return new BookInfo(BookId,BookName,Author,Translator,Price,ISBNCode,ComeUpTime,PublishCompany,State,EnteringMen,EnteringDate);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("实例化一个BookInfo对象失败!");
            return null;
        }
    }
}
