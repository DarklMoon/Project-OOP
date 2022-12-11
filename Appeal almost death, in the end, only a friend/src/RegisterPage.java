import java.awt.BorderLayout;import java.awt.FlowLayout;import java.awt.Font;import java.awt.GridLayout;import javax.swing.*;import javax.swing.border.EmptyBorder;public class RegisterPage {    private JFrame frame;    private JLabel nameLabel, emailLabel, passLabel, regLabel, confirmPassLabel;    private JTextField nameTextField, emailTextField;    private JPasswordField passField, confirmPassField;    private JPanel panel, namePanel, emailPanel, passPanel, confirmPassPanel, btnPanel;    private JButton regBtn, loginBtn;        public RegisterPage(){        frame = new JFrame("Register");        frame.setLayout(new BorderLayout());                panel = new JPanel();        panel.setLayout(new GridLayout(4,1));        panel.setBorder(new EmptyBorder(30,30,10,30));                regLabel = new JLabel("Register", SwingConstants.CENTER);        regLabel.setFont(new Font("Verdana", Font.PLAIN, 52));        regLabel.setBorder(new EmptyBorder(10,0,0,0));        frame.add(regLabel, BorderLayout.NORTH);                namePanel = new JPanel();        namePanel.setLayout(new GridLayout(1,2));        nameLabel = new JLabel("Username: ");        nameTextField = new JTextField();        namePanel.add(nameLabel);        namePanel.add(nameTextField);        panel.add(namePanel);                emailPanel = new JPanel();        emailPanel.setLayout(new GridLayout(1,2));        emailLabel = new JLabel("Email: ");        emailTextField = new JTextField();        emailPanel.add(emailLabel);        emailPanel.add(emailTextField);        panel.add(emailPanel);                passPanel = new JPanel();        passPanel.setLayout(new GridLayout(1,2));        passLabel = new JLabel("Password: ");        passField = new JPasswordField();        passPanel.add(passLabel);        passPanel.add(passField);        panel.add(passPanel);                confirmPassPanel = new JPanel();        confirmPassPanel.setLayout(new GridLayout(1,2));        confirmPassLabel = new JLabel("Confirm Password: ");        confirmPassField = new JPasswordField();        confirmPassPanel.add(confirmPassLabel);        confirmPassPanel.add(confirmPassField);        panel.add(confirmPassPanel);                frame.add(panel, BorderLayout.CENTER);                btnPanel = new JPanel();        btnPanel.setLayout(new FlowLayout());        regBtn = new JButton("Create Account");        loginBtn = new JButton("Go to Login");        btnPanel.add(regBtn);        btnPanel.add(loginBtn);        btnPanel.setBorder(new EmptyBorder(0,0,10,0));        frame.add(btnPanel, BorderLayout.SOUTH);                frame.setSize(450,350);        frame.setResizable(false);        frame.setLocationRelativeTo(null);        //frame.setVisible(true);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    }        public JButton getLoginBtn(){return this.loginBtn;}    public JButton getRegBtn(){return this.regBtn;}    public JFrame getFrame(){return this.frame;}}