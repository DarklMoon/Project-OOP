import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsAdminPanel extends JPanel{
    private JButton setAdminPassBtn, logoutBtn, exitBtn, changeNameBtn, changePasswordBtn, changeEmailBtn;
    private JLabel settingsLabel;
    private JPanel panel;
    private Font font;
    
    public SettingsAdminPanel(){
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(139, 188, 204));
        
        settingsLabel = new JLabel("Settings", SwingConstants.CENTER);
        settingsLabel.setForeground(Color.BLACK);
        settingsLabel.setFont(new Font("Sarabun", Font.BOLD, 52));
        settingsLabel.setBorder(new EmptyBorder(30,0,0,0));
        this.add(settingsLabel, BorderLayout.NORTH);
        
        panel = new JPanel();
        panel.setBackground(new Color(139, 188, 204));
        GridLayout layout = new GridLayout(3,2);
        layout.setVgap(25);
        layout.setHgap(25);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(50,180,100,180));
        
        font = new Font("Sarabun", Font.BOLD, 16);
        setAdminPassBtn = new JButton("Admin Password Settings");
        setAdminPassBtn.setFont(font);
        setAdminPassBtn.setForeground(Color.WHITE);
        setAdminPassBtn.setBackground(new Color(76, 103, 147));
        logoutBtn = new JButton("Logout");
        logoutBtn.setFont(font);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBackground(new Color(76, 103, 147));
        exitBtn = new JButton("Exit");
        exitBtn.setFont(font);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBackground(new Color(76, 103, 147));
        changeNameBtn = new JButton("Change Name");
        changeNameBtn.setFont(font);
        changeNameBtn.setForeground(Color.WHITE);
        changeNameBtn.setBackground(new Color(76, 103, 147));
        changePasswordBtn = new JButton("Change Password");
        changePasswordBtn.setFont(font);
        changePasswordBtn.setForeground(Color.WHITE);
        changePasswordBtn.setBackground(new Color(76, 103, 147));
        changeEmailBtn = new JButton("Change Email");
        changeEmailBtn.setFont(font);
        changeEmailBtn.setForeground(Color.WHITE);
        changeEmailBtn.setBackground(new Color(76, 103, 147));
        
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
