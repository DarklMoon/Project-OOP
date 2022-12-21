import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterPage {
    private JFrame frame;
    private JLabel usernameLabel, firstnameLabel, lastnameLabel, emailLabel, passLabel, regLabel, confirmPassLabel;
    private JTextField usernameTextField, emailTextField, firstnameTextField, lastnameTextField;
    private JPasswordField passField, confirmPassField;
    private JPanel panel, firstnamePanel, lastnamePanel, usernamePanel, emailPanel, passPanel, confirmPassPanel, btnPanel;
    private JButton regBtn, loginBtn;
    private Font font, font2;
    
    public RegisterPage(){
        frame = new JFrame("Register");
        frame.setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setBackground(new Color(139, 188, 204));
        panel.setLayout(new GridLayout(6,1));
        panel.setBorder(new EmptyBorder(30,30,10,30));
        
        regLabel = new JLabel("Register", SwingConstants.CENTER);
        regLabel.setBackground(new Color(139, 188, 204));
        regLabel.setOpaque(true);
        regLabel.setFont(new Font("Sarabun", Font.BOLD, 52));
        regLabel.setBorder(new EmptyBorder(10,0,0,0));
        frame.add(regLabel, BorderLayout.NORTH);
        
        font = new Font("Sarabun", Font.BOLD, 18);
        font2 = new Font("Sarabun", Font.PLAIN, 16);
        
        firstnamePanel = new JPanel();
        firstnamePanel.setBackground(new Color(139, 188, 204));
        firstnamePanel.setLayout(new GridLayout(1,2));
        firstnameLabel = new JLabel("Firstname: ");
        firstnameLabel.setFont(font);
        firstnameTextField = new JTextField();
        firstnameTextField.setFont(font2);
        firstnamePanel.add(firstnameLabel);
        firstnamePanel.add(firstnameTextField);
        panel.add(firstnamePanel);
        
        lastnamePanel = new JPanel();
        lastnamePanel.setBackground(new Color(139, 188, 204));
        lastnamePanel.setLayout(new GridLayout(1,2));
        lastnameLabel = new JLabel("Lastname: ");
        lastnameLabel.setFont(font);
        lastnameTextField = new JTextField();
        lastnameTextField.setFont(font2);
        lastnamePanel.add(lastnameLabel);
        lastnamePanel.add(lastnameTextField);
        panel.add(lastnamePanel);
        
        usernamePanel = new JPanel();
        usernamePanel.setBackground(new Color(139, 188, 204));
        usernamePanel.setLayout(new GridLayout(1,2));
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(font);
        usernameTextField = new JTextField();
        usernameTextField.setFont(font2);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        panel.add(usernamePanel);
        
        emailPanel = new JPanel();
        emailPanel.setBackground(new Color(139, 188, 204));
        emailPanel.setLayout(new GridLayout(1,2));
        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(font);
        emailTextField = new JTextField();
        emailTextField.setFont(font2);
        emailPanel.add(emailLabel);
        emailPanel.add(emailTextField);
        panel.add(emailPanel);
        
        passPanel = new JPanel();
        passPanel.setBackground(new Color(139, 188, 204));
        passPanel.setLayout(new GridLayout(1,2));
        passLabel = new JLabel("Password: ");
        passLabel.setFont(font);
        passField = new JPasswordField();
        passPanel.add(passLabel);
        passPanel.add(passField);
        panel.add(passPanel);
        
        confirmPassPanel = new JPanel();
        confirmPassPanel.setBackground(new Color(139, 188, 204));
        confirmPassPanel.setLayout(new GridLayout(1,2));
        confirmPassLabel = new JLabel("Confirm Password: ");
        confirmPassLabel.setFont(font);
        confirmPassField = new JPasswordField();
        confirmPassPanel.add(confirmPassLabel);
        confirmPassPanel.add(confirmPassField);
        panel.add(confirmPassPanel);
        
        frame.add(panel, BorderLayout.CENTER);
        
        btnPanel = new JPanel();
        btnPanel.setBackground(new Color(139, 188, 204));
        btnPanel.setLayout(new FlowLayout());
        regBtn = new JButton("Create Account");
        regBtn.setFont(new Font("Sarabun", Font.BOLD, 13));
        regBtn.setForeground(Color.WHITE);
        regBtn.setBackground(new Color(76, 103, 147));
        loginBtn = new JButton("Go to Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new Color(76, 103, 147));
        loginBtn.setFont(new Font("Sarabun", Font.BOLD, 13));
        btnPanel.add(regBtn);
        btnPanel.add(loginBtn);
        btnPanel.setBorder(new EmptyBorder(10,0,10,0));
        frame.add(btnPanel, BorderLayout.SOUTH);
        
        frame.setSize(450,460);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JButton getLoginBtn(){return this.loginBtn;}
    public JButton getRegBtn(){return this.regBtn;}
    public JFrame getFrame(){return this.frame;}

    public JTextField getFirstnameTextField(){return this.firstnameTextField;}
    public JTextField getLastnameTextField(){return this.lastnameTextField;}    
    public JTextField getUsernameTextField(){return this.usernameTextField;}
    public JTextField getEmailTextField(){return this.emailTextField;}
    public JPasswordField getPasswordField(){return this.passField;}
    public JPasswordField getConfirmPassField(){return this.confirmPassField;}
    
    public void reset(){
        this.firstnameTextField.setText("");
        this.lastnameTextField.setText("");
        this.usernameTextField.setText("");
        this.emailTextField.setText("");
        this.passField.setText("");
        this.confirmPassField.setText("");
    }
}
