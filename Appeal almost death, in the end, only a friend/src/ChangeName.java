import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangeName {
    private JFrame frame;
    private JPanel mainPanel, buttonPanel;
    private JTextField firstnameField, lastnameField;
    private JButton button;
    private JLabel firstnameLabel, lastnameLabel;
    
    public ChangeName(){
        frame = new JFrame("Change Name");
        
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(15,30,15,30));
        mainPanel.setLayout(new GridLayout(5,1));
        
        firstnameLabel = new JLabel("Enter new firstname:");
        mainPanel.add(firstnameLabel);
        firstnameField = new JTextField();
        mainPanel.add(firstnameField);
        
        lastnameLabel = new JLabel("Enter new lastname:");
        mainPanel.add(lastnameLabel);
        lastnameField = new JTextField();
        mainPanel.add(lastnameField);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        button = new JButton("Change Name");
        buttonPanel.add(button);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel);
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300,300);
    }
    
    public JFrame getFrame(){return this.frame;}
    public JButton getButton(){return this.button;}
    public JTextField getFirstnameField(){return this.firstnameField;}
    public JTextField getLastnameField(){return this.lastnameField;}
    
    public void resetField(){this.firstnameField.setText(""); this.lastnameField.setText("");}
}
