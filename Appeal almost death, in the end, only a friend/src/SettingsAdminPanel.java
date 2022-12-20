import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsAdminPanel extends JPanel{
    private JButton setAdminPassBtn, logoutBtn, exitBtn, changeNameBtn, changePasswordBtn, changeEmailBtn;
    private JLabel settingsLabel;
    private JPanel panel;
    
    public SettingsAdminPanel(){
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        settingsLabel = new JLabel("Settings", SwingConstants.CENTER);
        settingsLabel.setFont(new Font("Verdana", Font.BOLD, 52));
        settingsLabel.setBorder(new EmptyBorder(30,0,0,0));
        this.add(settingsLabel, BorderLayout.NORTH);
        
        panel = new JPanel();
        GridLayout layout = new GridLayout(3,2);
        layout.setVgap(25);
        layout.setHgap(25);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(50,180,100,180));
        
        setAdminPassBtn = new JButton("Admin Password Settings");
        logoutBtn = new JButton("Logout");
        exitBtn = new JButton("Exit");
        changeNameBtn = new JButton("Change Name");
        changePasswordBtn = new JButton("Change Password");
        changeEmailBtn = new JButton("Change Email");
        
        panel.add(changeNameBtn);
        panel.add(setAdminPassBtn);
        panel.add(changePasswordBtn);
        panel.add(logoutBtn);
        panel.add(changeEmailBtn);
        panel.add(exitBtn);
        this.add(panel, BorderLayout.CENTER);
    }
    
    public JButton getChangeNameButton(){return this.changeNameBtn;}
    public JButton getChangePasswordButton(){return this.changePasswordBtn;}
    public JButton getChangeEmailButton(){return this.changeEmailBtn;}
    public JButton getAdminButton(){return this.setAdminPassBtn;}
    public JButton getLogoutButton(){return this.logoutBtn;}
    public JButton getExitButton() {return this.exitBtn;}
}
