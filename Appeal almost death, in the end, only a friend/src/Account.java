public class Account {
    private String firstname,lastname,username,password,email;
    
    public Account(){this("","","","","");}
    public Account(String firstname,String lastname,String username,String password, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public String getFirstname(){return this.firstname;}
    public String getLastname(){return this.lastname;}
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}
    
    public void setFirstname(String firstname){this.firstname = firstname;}
    public void setLastname(String lastname){this.lastname = lastname;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setEmail(String email){this.email = email;}
}
