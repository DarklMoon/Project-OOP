import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SettingsPanel extends JPanel{
    private JButton setAdminBtn, LogoutBtn;
    private JLabel settingsLabel;
    private JPanel panel;
    
    public SettingsPanel(){
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        settingsLabel = new JLabel("Settings", SwingConstants.CENTER);
        settingsLabel.setFont(new Font("Verdana", Font.PLAIN, 52));
        settingsLabel.setBorder(new EmptyBorder(30,0,0,0));
        this.add(settingsLabel, BorderLayout.NORTH);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(new EmptyBorder(50,350,100,350));
        
        setAdminBtn = new JButton("Admin Verifying");
        LogoutBtn = new JButton("Logout");
        
        panel.add(setAdminBtn);
        panel.add(LogoutBtn);
        this.add(panel, BorderLayout.CENTER);
    }
}
