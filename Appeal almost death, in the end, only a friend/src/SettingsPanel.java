import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsPanel extends JPanel{
    private JButton setAdminBtn, LogoutBtn, exitBtn;
    private JLabel settingsLabel;
    private JPanel panel;
    
    public SettingsPanel(){
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        settingsLabel = new JLabel("Settings", SwingConstants.CENTER);
        settingsLabel.setFont(new Font("Verdana", Font.BOLD, 52));
        settingsLabel.setBorder(new EmptyBorder(30,0,0,0));
        this.add(settingsLabel, BorderLayout.NORTH);
        
        panel = new JPanel();
        GridLayout layout = new GridLayout(3,1);
        layout.setVgap(50);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(50,350,100,350));
        
        setAdminBtn = new JButton("Admin Verifying");
        LogoutBtn = new JButton("Logout");
        exitBtn = new JButton("Exit");
        
        panel.add(setAdminBtn);
        panel.add(LogoutBtn);
        panel.add(exitBtn);
        this.add(panel, BorderLayout.CENTER);
    }
    
    public JButton getAdminButton(){return this.setAdminBtn;}
    public JButton getLoginButton(){return this.setAdminBtn;}
    public JButton getExitButton() {return this.exitBtn;}
}
