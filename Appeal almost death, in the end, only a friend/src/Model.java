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
import org.jfree.data.category.DefaultCategoryDataset;

public class Model {
    private Account account;
    private Report report;
    private TypeAmount type;
    private Connection connect = null;
    private Statement s = null;
    private String sqlUsername = "root";
    private String sqlPassword = "";
    
    public Model(){
        this.account = new Account();
        this.report = new Report();
        this.type = new TypeAmount();
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
                        + "username varchar(50) not null,"
                        + "email varchar(100) not null,"
                        + "status varchar(20) not null,"
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
    
    public void logout(){
        this.account = new Account();
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
            s.executeUpdate(sql);
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
            String sql = "select * from account where username = '"+account.getUsername()+"';";
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
            String username = account.getUsername();
            String email = account.getEmail();
            String status = "Pending";
            String sql = "INSERT INTO report (type,location,date,detail,username,email,status)"
                    + " VALUES ('"+type+"','"+location+"','"+dateString+"','"+detail+"','"+username+"','"+email+"','"+status+"');";
            s.executeUpdate(sql);
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public void getType(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "select count(*) as dsa from report where type = 'Deserted area';";
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            int dsa = rs.getInt("dsa");
            
            sql = "select count(*) as dfa from report where type = 'Defective area';";
            rs = s.executeQuery(sql);
            rs.next();
            int dfa = rs.getInt("dfa");
            
            sql = "select count(*) as iga from report where type = 'Illegal area';";
            rs = s.executeQuery(sql);
            rs.next();
            int iga = rs.getInt("iga");
            
            sql = "select count(*) as mis from report where type = 'Mischief';";
            rs = s.executeQuery(sql);
            rs.next();
            int mis = rs.getInt("mis");
            
            sql = "select count(*) as tfo from report where type = 'Traffic offenders';";
            rs = s.executeQuery(sql);
            rs.next();
            int tfo = rs.getInt("tfo");
            
            sql = "select count(*) as nsp from report where type = 'Non-standard products';";
            rs = s.executeQuery(sql);
            rs.next();
            int nsp = rs.getInt("nsp");
            
            sql = "select count(*) as frd from report where type = 'Fraud/Corruption';";
            rs = s.executeQuery(sql);
            rs.next();
            int frd = rs.getInt("frd");
            
            sql = "select count(*) as oth from report where type = 'Other';";
            rs = s.executeQuery(sql);
            rs.next();
            int oth = rs.getInt("oth");
            
            type = new TypeAmount(dsa,dfa,iga,mis,tfo,nsp,frd,oth);
        } 
        catch (SQLException e) {e.printStackTrace();}
    }
    
    public void setChart(DefaultCategoryDataset dataset){
        if((type.getDSA() == 0)&&(type.getDFA() == 0)&&(type.getIGA() == 0)&&(type.getMIS() == 0)&&(type.getTFO() == 0)&&(type.getNSP() == 0)
                &&(type.getFRD() == 0)&&(type.getOTH()==0)){}
        else{
            dataset.setValue(type.getDSA(), "Marks", "Deserted area");
            dataset.setValue(type.getDFA(), "Marks", "Defective area");
            dataset.setValue(type.getIGA(), "Marks", "Illegal area");
            dataset.setValue(type.getMIS(), "Marks", "Mischief");
            dataset.setValue(type.getTFO(), "Marks", "Traffic offenders");
            dataset.setValue(type.getNSP(), "Marks", "Non-standard products");
            dataset.setValue(type.getFRD(), "Marks", "Fraud/Corruption");
            dataset.setValue(type.getOTH(), "Marks", "Other");
        }
    }
    
    public boolean setAdminPassword(String password){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "update adminPassword set password = '"+password+"';";
            s.executeUpdate(sql);
            return true;
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean setNewName(String firstname, String lastname){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "update account set firstname = '"+firstname+"' where username = '"+account.getUsername()+"';";
            s.executeUpdate(sql);
            sql = "update account set lastname = '"+lastname+"' where username = '"+account.getUsername()+"';";
            s.executeUpdate(sql);
            login(account.getUsername());
            return true;
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean setNewPassword(String password){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "update account set password = '"+password+"' where username = '"+account.getUsername()+"';";
            s.executeUpdate(sql);
            login(account.getUsername());
            return true;
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean setNewEmail(String email){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "update account set email = '"+email+"' where username = '"+account.getUsername()+"';";
            s.executeUpdate(sql);
            login(account.getUsername());
            return true;
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean setNewStatus(String ID, String status){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql = "update report set status = '"+status+"' where id = "+ID+";";
            s.executeUpdate(sql);
            login(account.getUsername());
            return true;
        } 
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public Object[][] getData(String panel) throws IOException{
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql;
            if(panel.equals("report")){sql = "select count(*) as num from report where status not in ('complete','failed');";}
            else{sql = "select count(*) as num from report where status in ('complete','failed');";}
            
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            int count = rs.getInt("num");
            if(panel.equals("report")){sql = "select * from report where status not in ('complete','failed');";}
            else{sql = "select * from report where status in ('complete','failed');";}
            
            rs = s.executeQuery(sql);
            Object[][] obj = new Object[count][8];
            int i = 0;
            while(rs.next()){
                String ID = String.valueOf(rs.getInt("ID"));
                String username = rs.getString("username");
                String type = rs.getString("type");
                String email = rs.getString("email");
                String date = rs.getString("date");
                String location = rs.getString("location");
                String detail = rs.getString("detail");
                String status = rs.getString("status");
                Object[] datas = {ID,username,type,email,date,location,detail,status};
                obj[i] = datas;   
                i++;
            }
            report.setData(obj);
            return obj;
        } 
        catch (SQLException e) {e.printStackTrace(); return null;}
    }
    
    public Object[][] getUserData() throws IOException{
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql",this.sqlUsername,this.sqlPassword);
            s = connect.createStatement();
            String sql;
            sql = "select count(*) as num from report where username = '"+account.getUsername()+"';";
            
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            int count = rs.getInt("num");
            sql = "select * from report where username = '"+account.getUsername()+"';";
            
            rs = s.executeQuery(sql);
            Object[][] obj = new Object[count][6];
            int i = 0;
            while(rs.next()){
                String ID = String.valueOf(rs.getInt("ID"));
                String type = rs.getString("type");
                String date = rs.getString("date");
                String location = rs.getString("location");
                String detail = rs.getString("detail");
                String status = rs.getString("status");
                Object[] datas = {ID,type,date,location,detail,status};
                obj[i] = datas;   
                i++;
            }
            report.setData(obj);
            return obj;
        } 
        catch (SQLException e) {e.printStackTrace(); return null;}
    }
}
