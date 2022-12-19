import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class Model {
    private Account account;
    private Report report;
    private Connection connect = null;
    private Statement s = null;
    private String sqlUsername = "root";
    private String sqlPassword = "";
    
    public Model(){
        account = new Account();
        report = new Report();
    }
    
    public Account getAccount(){return this.account;}
    public void setAccount(Account account){this.account = account;}
    
    public Report getReport(){return this.report;}
    public void setReport(Report report){this.report = report;}
    
    public void openDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "SET GLOBAL max_allowed_packet=1073741824;";
            s.execute(sql);
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "account", null);
            if (!tables.next()){
                sql = 
                        "create table account("
                        + "ID int not null auto_increment,"
                        + "firstname varchar(50) not null,"
                        + "lastname varchar(50) not null,"
                        + "username varchar(50) not null unique,"
                        + "email varchar(80) not null,"
                        + "password varchar(50) not null,"
                        + "admin bit(1) not null,"
                        + "primary key (ID)"
                        + ");";
                s.execute(sql);
            }
            tables = dbm.getTables(null, null, "report", null);
            if (!tables.next()){
                sql = 
                        "create table report("
                        + "ID int not null auto_increment,"
                        + "type varchar(50) not null,"
                        + "location varchar(150) not null,"
                        + "date varchar(10) not null,"
                        + "detail text not null,"
                        + "image longblob,"
                        + "username varchar(50) not null,"
                        + "primary key (ID)"
                        + ");";
                s.execute(sql);
            }
            tables = dbm.getTables(null, null, "adminPassword", null);
            if (!tables.next()){
                sql = 
                        "create table adminPassword("
                        + "password varchar(50) not null"
                        + ");";
                s.execute(sql);
                sql = "insert into adminPassword (password) value('admin');";
                s.execute(sql);
            }
        } 
        catch (Exception e) {e.printStackTrace();}
    }
    
    public void closeDataBase(){
        try {
            if (connect != null) {
                s.close();
                connect.close();
            }
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public boolean checkUserName(String username){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select username from account where username = '"+username+"';";
            ResultSet rs = s.executeQuery(sql);
            return rs.next();
        }
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean checkPassword(String username,String password){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select * from account where username = '"+username+"';";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                return password.equals(rs.getString("password"));
            }
            else{return false;}
        }
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public void login(String username){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select * from account where username = '"+username+"';";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                account = new Account(rs.getString("firstname")
                        ,rs.getString("lastname")
                        ,rs.getString("username")
                        ,rs.getString("password")
                        ,rs.getString("email")
                        ,rs.getBoolean("admin")
                );
            }
        }
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public void creatAccount(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String firstname = account.getFirstname();
            String lastname = account.getLastname();
            String username = account.getUsername();
            String email = account.getEmail();
            String password = account.getPassword();
            String sql = "INSERT INTO account (firstname,lastname,username,email,password,admin)"
                    + " VALUES ("+"'"+firstname+"'"+","+"'"+lastname+"'"+","+"'"+username+"'"+","+"'"+email+"'"+","+"'"+password+"'"+",0);";
            int n = s.executeUpdate(sql);
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public boolean setAdmin(String password){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select * from adminPassword";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){return password.equals(rs.getString("password"));}
            else{return false;}
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public void changeToAdmin(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select * from account where username = "+account.getUsername()+";";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                sql = "update account set admin = true where username = '"+account.getUsername()+"';";
                s.executeUpdate(sql);
            }
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public byte[] extractBytes(File file){
        try{
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableRaster raster = bufferedImage.getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
            return (data.getData());
        }
        catch(IOException e){e.printStackTrace(); return null;}
    }
    
    public void saveReportToSql(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            String type = report.getType();
            String location = report.getLocation();
            Date date = report.getDate();
            Format formatter = new SimpleDateFormat("MM-dd-yyyy");
            String dateString = formatter.format(date);
            String detail = report.getDetail();
            byte[] image = report.getImage();
            String username = account.getUsername();
            String sql = "INSERT INTO report (type,location,date,detail,image,username)"
                    + " VALUES ("+"'"+type+"'"+","+"'"+location+"'"+","+"'"+dateString+"'"+","+"'"+detail+"'"+",?,"+"'"+username+"');";
            PreparedStatement s = connect.prepareStatement(sql);
            s.setBytes(1, image);
            s.executeUpdate();
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
}