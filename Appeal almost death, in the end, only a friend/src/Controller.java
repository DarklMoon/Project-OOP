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
    private MainPageAdmin mainPageAdmin;
    private SetAdmin setAdmin;
    private Model model;
    
    public Controller(){
        regPage = new RegisterPage();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        mainPageAdmin = new MainPageAdmin();
        setAdmin = new SetAdmin();
        model = new Model();
        init();
    }
    
    private void init(){
        regPage.getRegBtn().addActionListener(this);
        regPage.getLoginBtn().addActionListener(this);
        loginPage.getRegBtn().addActionListener(this);
        loginPage.getLoginBtn().addActionListener(this);
        loginPage.getFrame().addWindowListener(this);
        mainPage.getIconButton().addActionListener(this);
        mainPage.getReportButton().addActionListener(this);
        mainPage.getAccountButton().addActionListener(this);
        mainPage.getSettingsButton().addActionListener(this);
        mainPageAdmin.getIconButton().addActionListener(this);
        mainPageAdmin.getReportButton().addActionListener(this);
        mainPageAdmin.getAccountButton().addActionListener(this);
        mainPageAdmin.getSettingsButton().addActionListener(this);
        mainPageAdmin.getFrame().addWindowListener(this);
        mainPage.getFrame().addWindowListener(this);
        mainPage.getSettingsPanel().getAdminButton().addActionListener(this);
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
                            model.login(username);
                            loginPage.getFrame().setVisible(false);
                            if(model.getAccount().getIsAdmin()==true){mainPageAdmin.getFrame().setVisible(true);}
                            else{mainPage.getFrame().setVisible(true);}
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
                                    model.setAccount(new Account(firstname,lastname,username,password,email,false));
                                    model.creatAccount();
                                    regPage.getFrame().setVisible(false);
                                    loginPage.getFrame().setVisible(true);
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
        if(e.getSource().equals(mainPage.getIconButton())){mainPage.setMainPanel();}
        if(e.getSource().equals(mainPage.getReportButton())){mainPage.setReportPanel();}
        if(e.getSource().equals(mainPage.getSettingsButton())){mainPage.setSettingsPanel();}
        
        if(e.getSource().equals(mainPageAdmin.getIconButton())){mainPageAdmin.setMainPanel();}
        if(e.getSource().equals(mainPageAdmin.getReportButton())){mainPageAdmin.setReportTablePanel();}
        if(e.getSource().equals(mainPageAdmin.getSettingsButton())){mainPageAdmin.setSettingsPanel();}
        
        if(e.getSource().equals(mainPage.getSettingsPanel().getAdminButton())){setAdmin.getFrame().setVisible(true);}
        
    }

    @Override public void windowOpened(WindowEvent e) {model.openDataBase();}
    @Override public void windowClosing(WindowEvent e) {model.closeDataBase();}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}