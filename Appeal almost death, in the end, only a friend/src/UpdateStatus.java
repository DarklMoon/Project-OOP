import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UpdateStatus {
    private JFrame frame;
    private JLabel title, idLabel, statusLabel;
    private JButton confirmBtn;
    private JTextField idTf;
    private JPanel header, updatePanel,idPanel, btnPanel, statusPanel;
    private JComboBox comboBox;
    
    public UpdateStatus(){
        frame = new JFrame("Update Panel");
        frame.setLayout(new BorderLayout());
        updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(2,1));
        idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout());
        idLabel = new JLabel("ID : ");
        idTf = new JTextField();
        idTf.setColumns(5);
        idPanel.add(idLabel); 
        idPanel.add(idTf);
        idPanel.setBorder(new EmptyBorder(30,0,0,0));
        
        statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());
        statusLabel = new JLabel("STATUS : ");
        comboBox = new JComboBox();
        comboBox.addItem("Pending");
        comboBox.addItem("In progress");
        comboBox.addItem("Failed");
        comboBox.addItem("Complete");
        statusPanel.add(statusLabel);
        statusPanel.add(comboBox);
        statusPanel.setBorder(new EmptyBorder(10,0,0,0));
        
        updatePanel.add(idPanel); 
        updatePanel.add(statusPanel);
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        confirmBtn = new JButton("Confirm");
        btnPanel.add(confirmBtn);

        frame.add(updatePanel,BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.setSize(225,200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(false);
    }
    
    public JFrame getFrame(){return this.frame;}
    public JTextField getIdField(){return this.idTf;}
    public JComboBox getComboBox(){return this.comboBox;}
    public JButton getBtn(){return this.confirmBtn;}
    public void resetField(){this.idTf.setText("");}
}
