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
    
    public String setFirstname(){return this.firstname;}
    public String setLastname(){return this.lastname;}
    public String setUsername(){return this.username;}
    public String setPassword(){return this.password;}
    public String setEmail(){return this.email;}
    
    public void getFirstname(String firstname){this.firstname = firstname;}
    public void getLastname(String lastname){this.lastname = lastname;}
    public void getUsername(String username){this.username = username;}
    public void getPassword(String password){this.password = password;}
    public void getEmail(String email){this.email = email;}
}
