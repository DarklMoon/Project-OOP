import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;

public class SettingsPanel extends JPanel{
    private JButton setAdminBtn, LogoutBtn;
    
    public SettingsPanel(){
        this.setLayout(new BorderLayout());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        setAdminBtn = new JButton("Admin Verifying");
        this.add(setAdminBtn, BorderLayout.CENTER);
    }
}
