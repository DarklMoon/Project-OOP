import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangeEmail {
    private JFrame frame;
    private JPanel mainPanel, buttonPanel;
    private JTextField emailField;
    private JButton button;
    private JLabel label;
    
    public ChangeEmail(){
        frame = new JFrame("Change Email");
        
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(15,30,15,30));
        mainPanel.setLayout(new GridLayout(3,1));
        
        label = new JLabel("Enter new email:");
        mainPanel.add(label);
        emailField = new JTextField();
        mainPanel.add(emailField);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        button = new JButton("Change Email");
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
    public JTextField getEmailField(){return this.emailField;}
    
    public void resetField(){this.emailField.setText("");}
}
