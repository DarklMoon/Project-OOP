import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{
    private RegisterPage regPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private Model model;
    
    public Controller(){
        regPage = new RegisterPage();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        model = new Model();
        init();
    }
    
    private void init(){
        regPage.getRegBtn().addActionListener(this);
        regPage.getLoginBtn().addActionListener(this);
        loginPage.getRegBtn().addActionListener(this);
        loginPage.getLoginBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(loginPage.getLoginBtn())){
            System.out.println("Login Test");
            loginPage.getFrame().setVisible(false);
            mainPage.getFrame().setVisible(true);
            
        }
        if(e.getSource().equals(loginPage.getRegBtn())){
            loginPage.getFrame().setVisible(false);
            regPage.getFrame().setVisible(true);
        }
        if(e.getSource().equals(regPage.getLoginBtn())){
            loginPage.getFrame().setVisible(true);
            regPage.getFrame().setVisible(false);
        }
        if(e.getSource().equals(regPage.getRegBtn())){
            if(regPage.getNameTextField().getText().equals("")){
                JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your username.","Missing Username",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String username = regPage.getNameTextField().getText();
                if(regPage.getEmailTextField().getText().equals("")){
                    JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your email.","Missing Email",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    String email = regPage.getEmailTextField().getText();
                    if(Arrays.equals(regPage.getPasswordField().getPassword(), regPage.getConfirmPassField().getPassword()) && (regPage.getPasswordField().getPassword()).length!=0){
                        String password = Arrays.toString(regPage.getPasswordField().getPassword());
                        regPage.getFrame().setVisible(false);
                        mainPage.getFrame().setVisible(true);
                        model.setAccount(new Account(username,password,email));
                    }
                    else if(regPage.getPasswordField().getPassword().length==0){
                        JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your password.","Missing Password",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(regPage.getFrame(),"Password not match, please check your password.","Password not match",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}