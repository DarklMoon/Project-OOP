import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPage {
    private JFrame frame;
    private JLabel usernameLabel, passLabel, loginLabel;
    private JTextField usernameTextField;
    private JPasswordField passField, confirmPassField;
    private JPanel panel, usernamePanel, passPanel, btnPanel;
    private JButton loginBtn, regBtn;
    private Font fontLabel, fontTF;
    
    public LoginPage(){
        frame = new JFrame("Login");
        frame.setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setBackground(new Color(139, 188, 204));
        panel.setLayout(new GridLayout(2,1));
        panel.setBorder(new EmptyBorder(30,30,85,30));
        
        loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setBackground(new Color(139, 188, 204));
        loginLabel.setOpaque(true);
        loginLabel.setFont(new Font("Sarabun", Font.BOLD, 52));
        loginLabel.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(loginLabel, BorderLayout.NORTH);
        
        fontLabel = new Font("Sarabun", Font.BOLD, 18);
        fontTF = new Font("Sarabun", Font.PLAIN, 16);
        
        usernamePanel = new JPanel();
        usernamePanel.setLayout(new GridLayout(1,2));
        usernamePanel.setBackground(new Color(139, 188, 204));
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(fontLabel);
        
        usernameTextField = new JTextField();
        usernameTextField.setFont(fontTF);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        panel.add(usernamePanel);
        
        passPanel = new JPanel();
        
        passPanel.setLayout(new GridLayout(1,2));
        passPanel.setBackground(new Color(139, 188, 204));
        passLabel = new JLabel("Password: ");
        passLabel.setFont(fontLabel);
        passField = new JPasswordField();
        passPanel.add(passLabel);
        passPanel.add(passField);
        panel.add(passPanel);
        
        frame.add(panel, BorderLayout.CENTER);
        
        btnPanel = new JPanel();
        
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setBackground(new Color(139, 188, 204));
        loginBtn = new JButton("Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new Color(76, 103, 147));
        loginBtn.setFont(new Font("Sarabun", Font.BOLD, 13));
        regBtn = new JButton("Create an Account");
        regBtn.setForeground(Color.WHITE);
        regBtn.setBackground(new Color(76, 103, 147));
        regBtn.setFont(new Font("Sarabun", Font.BOLD, 13));
        btnPanel.add(loginBtn);
        btnPanel.add(regBtn);
        btnPanel.setBorder(new EmptyBorder(0,0,10,0));
        frame.add(btnPanel, BorderLayout.SOUTH);
        
        frame.setSize(450,350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JButton getLoginBtn(){return this.loginBtn;}
    public JButton getRegBtn(){return this.regBtn;}
    public JFrame getFrame(){return this.frame;}
    
    public JTextField getUsernameTextField(){return this.usernameTextField;}
    public JPasswordField getPasswordField(){return this.passField;}
    
    public void reset(){
        this.usernameTextField.setText("");
        this.passField.setText("");
    }
}
