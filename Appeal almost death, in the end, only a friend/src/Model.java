import java.sql.*;

public class Model {
    private Account account;
    private Connection connect = null;
    private Statement s = null;
    
    public Model(){
        account = new Account();
    }
    
    public Account getAccount(){return this.account;}
    public void setAccount(Account account){this.account = account;}
    
    public void openDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","");
            s = connect.createStatement();
            System.out.println("Connect Successful");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeDataBase(){
        try {
            if (connect != null) {
                s.close();
                connect.close();
                System.out.println("Close Successful");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}