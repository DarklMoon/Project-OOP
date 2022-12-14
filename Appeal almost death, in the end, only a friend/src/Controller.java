import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Controller implements ActionListener, WindowListener{
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
        loginPage.getFrame().addWindowListener(this);
        mainPage.getFrame().addWindowListener(this);
        regPage.getFrame().addWindowListener(this);
        loginPage.getFrame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(loginPage.getLoginBtn())){
            if(loginPage.getUsernameTextField().getText().equals("")){
                JOptionPane.showMessageDialog(loginPage.getFrame(),"Please enter your username.","Missing Username",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String username = loginPage.getUsernameTextField().getText();
                if(loginPage.getPasswordField().getPassword().length==0){
                    JOptionPane.showMessageDialog(loginPage.getFrame(),"Please enter your password.","Missing Password",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    String password = String.valueOf(loginPage.getPasswordField().getPassword());
                    if(model.checkUserName(username)==true){   
                        if(model.checkPassword(username, password)==true){
                            loginPage.getFrame().setVisible(false);
                            mainPage.getFrame().setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(loginPage.getFrame(),"Password not match. Please try again.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(loginPage.getFrame(),"Username not found. Please check your username.","Username not found",JOptionPane.ERROR_MESSAGE); 
                    }
                }
            }
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
            if(regPage.getFirstnameTextField().getText().equals("")){
                JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your firstname.","Missing Firstname",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String firstname = regPage.getFirstnameTextField().getText();
                if(regPage.getLastnameTextField().getText().equals("")){
                    JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your lastname.","Missing Lastname",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    String lastname = regPage.getLastnameTextField().getText();
                    if(regPage.getUsernameTextField().getText().equals("")){
                        JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your username.","Missing Username",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        String username = regPage.getUsernameTextField().getText();
                        if(regPage.getEmailTextField().getText().equals("")){
                            JOptionPane.showMessageDialog(regPage.getFrame(),"Please enter your email.","Missing Email",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            String email = regPage.getEmailTextField().getText();
                            if(Arrays.equals(regPage.getPasswordField().getPassword(), regPage.getConfirmPassField().getPassword()) && (regPage.getPasswordField().getPassword()).length!=0){
                                String password = String.valueOf(regPage.getPasswordField().getPassword());
                                if(model.checkUserName(username)==true){
                                    JOptionPane.showMessageDialog(regPage.getFrame(),"This username is already used. Please change your username.","Username is already used",JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                    model.setAccount(new Account(firstname,lastname,username,password,email));
                                    model.creatAccount();
                                    regPage.getFrame().setVisible(false);
                                    mainPage.getFrame().setVisible(true);  
                                }
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
    }

    @Override public void windowOpened(WindowEvent e) {model.loadSettings(); model.openDataBase();}
    @Override public void windowClosing(WindowEvent e) {model.saveSettings(); model.closeDataBase();}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}