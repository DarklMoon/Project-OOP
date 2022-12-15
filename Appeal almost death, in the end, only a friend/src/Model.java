import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

public class Model {
    private Account account;
    private Settings settings;
    private Connection connect = null;
    private Statement s = null;
    
    public Model(){
        account = new Account();
        settings = new Settings();
    }
    
    public Account getAccount(){return this.account;}
    public void setAccount(Account account){this.account = account;}
    
    public void openDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","dark1234");
            s = connect.createStatement();
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "account", null);
            if (tables.next()){settings.setTableCreated(true);}
            else{
                String sql = 
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
                boolean n = s.execute(sql);
                settings.setTableCreated(true);
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
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","dark1234");
            s = connect.createStatement();
            String sql = "select username from account where username = '"+username+"';";
            ResultSet rs = s.executeQuery(sql);
            return rs.next();
        }
        catch (SQLException e) {e.printStackTrace(); return false;}
    }
    
    public boolean checkPassword(String username,String password){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","dark1234");
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
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","dark1234");
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
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","dark1234");
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
    
    public void saveSettings(){
        try {
            FileOutputStream fOut = new FileOutputStream("Settings.conf");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);
            oout.writeObject(settings);
            oout.close(); 
            fOut.close();
        } 
        catch (IOException e) {e.printStackTrace();} 
    }
    
    public void loadSettings(){
        File f = new File("Settings.conf");
        if(f.exists() && !f.isDirectory()){ 
            try {
                FileInputStream fin = new FileInputStream("Settings.conf");
                ObjectInputStream in = new ObjectInputStream(fin);
                settings = (Settings) in.readObject();
                in.close();
                fin.close();
            } 
            catch (IOException i) {i.printStackTrace();} 
            catch (ClassNotFoundException c) {c.printStackTrace();}
        }
    }
}