import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class View {
    private JFrame mainFrame, firstFrame;
    private JPanel firstPanel, btnPanel;
    private JLabel appName;
    private JButton userBtn, adminBtn;
    
    public View(){
        firstFrame = new JFrame("Welcome");
        firstFrame.setLayout(new BorderLayout());
        
        appName = new JLabel("App name", SwingConstants.CENTER);
        appName.setFont(new Font("Verdana", Font.PLAIN, 52));      
        firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(2,1));
        firstPanel.add(appName);
        firstFrame.add(firstPanel, BorderLayout.CENTER);
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
        userBtn = new JButton("User");
        userBtn.setPreferredSize(new Dimension(120,50));
        userBtn.setFont(new Font("Verdana", Font.PLAIN, 24));
        adminBtn = new JButton("Admin");
        adminBtn.setPreferredSize(new Dimension(120,50));
        adminBtn.setFont(new Font("Verdana", Font.PLAIN, 24));
        
        btnPanel.add(userBtn);
        btnPanel.add(adminBtn);
        firstPanel.add(btnPanel);
        firstFrame.add(firstPanel, BorderLayout.CENTER);
        
        firstFrame.setSize(500,300);
        firstFrame.setResizable(false);
        firstFrame.setVisible(true);
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
