public class Account {
    private String username,password,email;
    
    public Account(){this("","","");}
    public Account(String username,String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}
    
    public void getUsername(String username){this.username = username;}
    public void getPassword(String password){this.password = password;}
    public void getEmail(String email){this.email = email;}
}
