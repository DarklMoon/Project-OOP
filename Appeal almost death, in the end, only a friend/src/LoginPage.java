import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPage {
    private JFrame frame;
    private JLabel nameLabel, passLabel, loginLabel;
    private JTextField nameTextField, emailTextField;
    private JPasswordField passField, confirmPassField;
    private JPanel panel, namePanel, passPanel, btnPanel;
    private JButton loginBtn, regBtn;
    
    public LoginPage(){
        frame = new JFrame("Login");
        frame.setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(new EmptyBorder(30,30,85,30));
        
        loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Verdana", Font.PLAIN, 52));
        loginLabel.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(loginLabel, BorderLayout.NORTH);
        
        namePanel = new JPanel();
        namePanel.setLayout(new GridLayout(1,2));
        nameLabel = new JLabel("Username: ");
        nameTextField = new JTextField();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        panel.add(namePanel);
        
        passPanel = new JPanel();
        passPanel.setLayout(new GridLayout(1,2));
        passLabel = new JLabel("Password: ");
        passField = new JPasswordField();
        passPanel.add(passLabel);
        passPanel.add(passField);
        panel.add(passPanel);
        
        frame.add(panel, BorderLayout.CENTER);
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        loginBtn = new JButton("Login");
        regBtn = new JButton("Create an Account");
        btnPanel.add(loginBtn);
        btnPanel.add(regBtn);
        btnPanel.setBorder(new EmptyBorder(0,0,10,0));
        frame.add(btnPanel, BorderLayout.SOUTH);
        
        frame.setSize(450,350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JButton getLoginBtn(){return this.loginBtn;}
    public JButton getRegBtn(){return this.regBtn;}
    public JFrame getFrame(){return this.frame;}
}
