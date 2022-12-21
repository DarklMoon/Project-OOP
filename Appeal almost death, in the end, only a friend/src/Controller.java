import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class Controller implements ActionListener, WindowListener{
    private RegisterPage regPage;
    private LoginPage loginPage;
    private MainPageUser mainPage;
    private MainAdminPage mainAdminPage;
    private SetAdmin setAdmin;
    private SetAdminPassword setAdminPassword;
    private ChangeName changeName;
    private ChangePassword changePass;
    private ChangeEmail changeEmail;
    private UpdateStatus updateStatus;
    private Model model;
    
    public Controller(){
        regPage = new RegisterPage();
        loginPage = new LoginPage();
        mainPage = new MainPageUser();
        mainAdminPage = new MainAdminPage();
        setAdmin = new SetAdmin();
        setAdminPassword = new SetAdminPassword();
        changeName = new ChangeName();
        changePass = new ChangePassword();
        changeEmail = new ChangeEmail();
        updateStatus = new UpdateStatus();
        model = new Model();
        init();
    }
    
    private void init(){
        regPage.getRegBtn().addActionListener(this);
        regPage.getLoginBtn().addActionListener(this);
        
        loginPage.getRegBtn().addActionListener(this);
        loginPage.getLoginBtn().addActionListener(this);
  
        mainPage.getIconButton().addActionListener(this);
        mainPage.getReportButton().addActionListener(this);
        mainPage.getAccountButton().addActionListener(this);
        mainPage.getSettingsButton().addActionListener(this);
        
        mainAdminPage.getIconButton().addActionListener(this);
        mainAdminPage.getReportButton().addActionListener(this);
        mainAdminPage.getAccountButton().addActionListener(this);
        mainAdminPage.getSettingsButton().addActionListener(this);
        mainAdminPage.getFrame().addWindowListener(this);
          
        mainPage.getSettingsPanel().getAdminButton().addActionListener(this);
        mainPage.getSettingsPanel().getExitButton().addActionListener(this);
        mainPage.getSettingsPanel().getLogoutButton().addActionListener(this);
        mainPage.getSettingsPanel().getChangeNameButton().addActionListener(this);
        mainPage.getSettingsPanel().getChangePasswordButton().addActionListener(this);
        mainPage.getSettingsPanel().getChangeEmailButton().addActionListener(this);
        
        mainAdminPage.getSettingsPanel().getAdminButton().addActionListener(this);
        mainAdminPage.getSettingsPanel().getExitButton().addActionListener(this);
        mainAdminPage.getSettingsPanel().getLogoutButton().addActionListener(this);
        mainAdminPage.getSettingsPanel().getChangeNameButton().addActionListener(this);
        mainAdminPage.getSettingsPanel().getChangePasswordButton().addActionListener(this);
        mainAdminPage.getSettingsPanel().getChangeEmailButton().addActionListener(this);
        
        mainPage.getReportPanel().getSummitBtn().addActionListener(this);  
        
        setAdmin.getButton().addActionListener(this);
        setAdminPassword.getButton().addActionListener(this);
        
        changeName.getButton().addActionListener(this);
        changePass.getButton().addActionListener(this);
        changeEmail.getButton().addActionListener(this);
        
        mainAdminPage.getReportTable().getUpdateBtn().addActionListener(this);
        updateStatus.getBtn().addActionListener(this);
              
        mainPage.getFrame().addWindowListener(this);
        mainAdminPage.getFrame().addWindowListener(this);
        loginPage.getFrame().addWindowListener(this);
        regPage.getFrame().addWindowListener(this);
        setAdmin.getFrame().addWindowListener(this);
        setAdminPassword.getFrame().addWindowListener(this);
        changeName.getFrame().addWindowListener(this);
        changePass.getFrame().addWindowListener(this);
        changeEmail.getFrame().addWindowListener(this);
        
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
                            loginPage.reset();
                            if(model.getAccount().getIsAdmin()==true){mainAdminPage.getFrame().setVisible(true); mainAdminPage.setMainPanel();}
                            else{mainPage.getFrame().setVisible(true); mainPage.setMainPanel();}
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
            loginPage.reset();
            regPage.getFrame().setVisible(true);
        }
        if(e.getSource().equals(regPage.getLoginBtn())){
            loginPage.getFrame().setVisible(true);
            regPage.getFrame().setVisible(false);
            regPage.reset();
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
                                    regPage.reset();
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
        if(e.getSource().equals(mainPage.getIconButton())){mainPage.setMainPanel(); mainPage.getReportPanel().reset();}
        if(e.getSource().equals(mainPage.getReportButton())){mainPage.setReportPanel();}
        if(e.getSource().equals(mainPage.getAccountButton())){
            mainPage.setAccountUserPanel();
            mainPage.getReportPanel().reset();
            try {
                Object[][] obj = model.getUserData();
                if(obj.length==0){mainPage.getAccountUser().setNoData();}
                mainPage.getAccountUser().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
            mainPage.getAccountUser().getTitle().setText(model.getAccount().getUsername());
            mainPage.getAccountUser().getEmail().setText(model.getAccount().getEmail());
        }
        if(e.getSource().equals(mainPage.getSettingsButton())){mainPage.setSettingsPanel(); mainPage.getReportPanel().reset();}
        
        if(e.getSource().equals(mainAdminPage.getIconButton())){mainAdminPage.setMainPanel();}
        if(e.getSource().equals(mainAdminPage.getReportButton())){
            mainAdminPage.setReportTablePanel();
            try {
                Object[][] obj = model.getData("report");
                if(obj.length==0){mainAdminPage.getReportTable().setNoData();}
                mainAdminPage.getReportTable().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
        }
        if(e.getSource().equals(mainAdminPage.getAccountButton())){
            mainAdminPage.setAccountAdminPanel();
            try {
                Object[][] obj = model.getData("account");
                if(obj.length==0){mainAdminPage.getAccountAdmin().setNoData();}
                mainAdminPage.getAccountAdmin().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
            mainAdminPage.getAccountAdmin().getTitle().setText(model.getAccount().getUsername());
            mainAdminPage.getAccountAdmin().getEmail().setText(model.getAccount().getEmail());
        }
        if(e.getSource().equals(mainAdminPage.getSettingsButton())){mainAdminPage.setSettingsPanel();}
        
        if(e.getSource().equals(mainPage.getSettingsPanel().getAdminButton())){setAdmin.getFrame().setVisible(true);}
        if(e.getSource().equals(mainPage.getSettingsPanel().getExitButton())){mainPage.exit();}
        if(e.getSource().equals(mainPage.getSettingsPanel().getLogoutButton())){model.logout(); mainPage.getFrame().setVisible(false); loginPage.getFrame().setVisible(true);}
        if(e.getSource().equals(mainPage.getSettingsPanel().getChangeNameButton())){changeName.getFrame().setVisible(true);}
        if(e.getSource().equals(mainPage.getSettingsPanel().getChangePasswordButton())){changePass.getFrame().setVisible(true);}
        if(e.getSource().equals(mainPage.getSettingsPanel().getChangeEmailButton())){changeEmail.getFrame().setVisible(true);}
        
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getAdminButton())){setAdminPassword.getFrame().setVisible(true);}
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getExitButton())){mainAdminPage.exit();}
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getLogoutButton())){model.logout(); mainAdminPage.getFrame().setVisible(false); loginPage.getFrame().setVisible(true);}
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getChangeNameButton())){changeName.getFrame().setVisible(true);}
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getChangePasswordButton())){changePass.getFrame().setVisible(true);}
        if(e.getSource().equals(mainAdminPage.getSettingsPanel().getChangeEmailButton())){changeEmail.getFrame().setVisible(true);}
        
        if(e.getSource().equals(mainPage.getReportPanel().getSummitBtn())){
            if(mainPage.getReportPanel().getComboBox().getSelectedItem()=="---PLEASE SELECT---"){
                JOptionPane.showMessageDialog(mainPage.getFrame(),"Please select report type.","Missing Report Type",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String reportType = mainPage.getReportPanel().getComboBox().getSelectedItem().toString();
                if(mainPage.getReportPanel().getLocationTextField().getText().equals("")){
                    JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter location.","Missing Location",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    String location = mainPage.getReportPanel().getLocationTextField().getText();
                    if(mainPage.getReportPanel().getDateTextField().getText().equals("")){
                        JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter date.","Missing Date",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        String dateString = mainPage.getReportPanel().getDateTextField().getText();
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = null;
                        try{date = formatter.parse(dateString);}
                        catch(Exception ex){JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter correct format. (Must include 0 in day and month.)","Error Format",JOptionPane.WARNING_MESSAGE);}
                        if(date!=null){
                            if(mainPage.getReportPanel().getDetailTextArea().getText().equals("")){
                                JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter details.","Missing Details",JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                                String detail = mainPage.getReportPanel().getDetailTextArea().getText();
                                    model.setReport(new Report(reportType,location,date,detail));
                                    model.saveReportToSql();
                                    model.getType(); 
                                    model.setChart(mainPage.getChartsPanel().getDataset());
                                    model.setChart(mainAdminPage.getChartsPanel().getDataset());
                                    JOptionPane.showMessageDialog(mainPage.getFrame(),"Report submit successfully.","Report Send",JOptionPane.INFORMATION_MESSAGE);
                                    mainPage.getReportPanel().reset();
                            }
                        }
                    }
                }
            }
        }
        if(e.getSource().equals(setAdmin.getButton())){
            if(setAdmin.getPasswordField().getPassword().length!=0){
                if(model.setAdmin(String.valueOf(setAdmin.getPasswordField().getPassword()))){
                    model.changeToAdmin();
                    JOptionPane.showMessageDialog(mainPage.getFrame(),"Change to admin successfully. Please re-login.","Admin verified",JOptionPane.INFORMATION_MESSAGE);
                    setAdmin.resetField();
                    setAdmin.getFrame().setVisible(false);
                    mainPage.getFrame().setVisible(false);
                    loginPage.getFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(mainPage.getFrame(),"Admin password not match. Please try again.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter admin password.","Missing Password",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource().equals(setAdminPassword.getButton())){
            if(setAdminPassword.getPasswordField().getPassword().length!=0){
                if(model.setAdminPassword(String.valueOf(setAdminPassword.getPasswordField().getPassword()))){
                    JOptionPane.showMessageDialog(mainPage.getFrame(),"Password change successfully.","Password Changed",JOptionPane.INFORMATION_MESSAGE);
                    setAdminPassword.resetField();
                    setAdminPassword.getFrame().setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(mainPage.getFrame(),"Please enter admin password.","Missing Password",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource().equals(changeName.getButton())){
            if(!changeName.getFirstnameField().getText().equals("")){
                if(!changeName.getLastnameField().getText().equals("")){
                    if(model.setNewName(changeName.getFirstnameField().getText(), changeName.getLastnameField().getText())){
                        JOptionPane.showMessageDialog(null,"Name change successfully.","Name Changed",JOptionPane.INFORMATION_MESSAGE);
                        changeName.resetField();
                        changeName.getFrame().setVisible(false);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter new lastname.","Missing Lastname",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please enter new firstname.","Missing Firstname",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource().equals(changePass.getButton())){
            if(changePass.getPassField().getPassword().length!=0){
                if(model.setNewPassword(String.valueOf(changePass.getPassField().getPassword()))){
                    JOptionPane.showMessageDialog(null,"Password change successfully.","Password Changed",JOptionPane.INFORMATION_MESSAGE);
                    changePass.resetField();
                    changePass.getFrame().setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please enter new password.","Missing Password",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource().equals(changeEmail.getButton())){
            if(!changeEmail.getEmailField().getText().equals("")){
                if(model.setNewEmail(changeEmail.getEmailField().getText())){
                    JOptionPane.showMessageDialog(null,"Email change successfully.","Email Changed",JOptionPane.INFORMATION_MESSAGE);
                    changeEmail.resetField();
                    changeEmail.getFrame().setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please enter new email.","Missing Email",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(e.getSource().equals(mainAdminPage.getReportTable().getUpdateBtn())){
            updateStatus.getFrame().setVisible(true);
        }
        
        if(e.getSource().equals(updateStatus.getBtn())){
            if(!updateStatus.getIdField().getText().equals("")){
                if(model.setNewStatus(updateStatus.getIdField().getText(), String.valueOf(updateStatus.getComboBox().getSelectedItem()))){
                    JOptionPane.showMessageDialog(null,"Status update successfully.","Status Update",JOptionPane.INFORMATION_MESSAGE);
                    updateStatus.resetField();
                    updateStatus.getFrame().setVisible(false); 
                }
                try {
                    Object[][] obj = model.getData("report");
                    if(obj.length==0){mainAdminPage.getReportTable().setNoData();}
                    mainAdminPage.getReportTable().getTableModel().setData(obj);
                }
                catch(IOException ex){ex.printStackTrace();}
                mainAdminPage.setReportTablePanel();
            }
            else{
                JOptionPane.showMessageDialog(null,"Please enter report id.","Missing ID",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override public void windowOpened(WindowEvent e) {
        if(e.getSource().equals(mainPage.getFrame())||
                e.getSource().equals(loginPage.getFrame())||
                e.getSource().equals(regPage.getFrame())||
                e.getSource().equals(mainAdminPage.getFrame())){
            model.openDataBase(); 
            model.getType(); 
            model.setChart(mainPage.getChartsPanel().getDataset());
            model.setChart(mainAdminPage.getChartsPanel().getDataset());
            try {
                Object[][] obj = model.getData("report");
                if(obj.length==0){mainAdminPage.getReportTable().setNoData();}
                mainAdminPage.getReportTable().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
            
            try {
                Object[][] obj = model.getData("account");
                if(obj.length==0){mainAdminPage.getAccountAdmin().setNoData();}
                mainAdminPage.getAccountAdmin().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
            
            try {
                Object[][] obj = model.getUserData();
                if(obj.length==0){mainPage.getAccountUser().setNoData();}
                mainPage.getAccountUser().getTableModel().setData(obj);
            }
            catch(IOException ex){ex.printStackTrace();}
        }
    }
    @Override public void windowClosing(WindowEvent e) {
        if(e.getSource().equals(mainPage.getFrame())||
                e.getSource().equals(loginPage.getFrame())||
                e.getSource().equals(regPage.getFrame())){
            model.closeDataBase();
        }
        if(e.getSource().equals(setAdmin.getFrame())){setAdmin.resetField();}
        if(e.getSource().equals(setAdminPassword.getFrame())){setAdminPassword.resetField();}
        if(e.getSource().equals(changeName.getFrame())){changeName.resetField();}
        if(e.getSource().equals(changePass.getFrame())){changePass.resetField();}
    }
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}