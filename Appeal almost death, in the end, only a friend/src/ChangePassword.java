import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangePassword {
    private JFrame frame;
    private JPanel mainPanel, buttonPanel;
    private JPasswordField passField;
    private JButton button;
    private JLabel label;
    
    public ChangePassword(){
        frame = new JFrame("Change Password");
        
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(15,30,15,30));
        mainPanel.setLayout(new GridLayout(3,1));
        
        label = new JLabel("Enter new password:");
        mainPanel.add(label);
        passField = new JPasswordField();
        mainPanel.add(passField);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        button = new JButton("Change Password");
        buttonPanel.add(button);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300,200);
    }
    
    public JFrame getFrame(){return this.frame;}
    public JButton getButton(){return this.button;}
    public JPasswordField getPassField(){return this.passField;}
    
    public void resetField(){this.passField.setText("");}
}
