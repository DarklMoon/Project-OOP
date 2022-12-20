import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsAdminPanel extends JPanel{
    private JButton setAdminPassBtn, logoutBtn, exitBtn, changePasswordBtn;
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
        GridLayout layout = new GridLayout(4,1);
        layout.setVgap(25);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(25,350,50,350));
        
        setAdminPassBtn = new JButton("Admin Password Settings");
        changePasswordBtn = new JButton("Change Password");
        logoutBtn = new JButton("Logout");
        exitBtn = new JButton("Exit");
        
        panel.add(setAdminPassBtn);
        panel.add(changePasswordBtn);
        panel.add(logoutBtn);
        panel.add(exitBtn);
        this.add(panel, BorderLayout.CENTER);
    }
    
    public JButton getAdminButton(){return this.setAdminPassBtn;}
    public JButton getChangePasswordButton(){return this.changePasswordBtn;}
    public JButton getLogoutButton(){return this.logoutBtn;}
    public JButton getExitButton() {return this.exitBtn;}
}
