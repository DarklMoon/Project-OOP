public class Model {
    private Account account;
    
    public Model(){
        account = new Account();
    }
    
    public Account getAccount(){return this.account;}
    public void setAccount(Account account){this.account = account;}
}