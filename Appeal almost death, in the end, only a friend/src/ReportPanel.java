import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.border.*;
import static javax.swing.ScrollPaneConstants.*;

public class ReportPanel extends JPanel{

    private JPanel mainPanel, typePanel, locationPanel, datePanel, detailPanel, p7, p9;
    private JButton submitBtn;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lbC;
    private JTextField tf1, tf2, tf3;
    private JComboBox cb;
    private JTextArea ta;
    private Box b1, b2, b3, b4, b6;
    private Font font, font2;
    private JScrollPane scroll;
    public static final Color VERY_LIGHT_RED = new Color(51, 204, 255);

    public ReportPanel() {
        this.setLayout(new BorderLayout());

        font = new Font("Tahoma", Font.PLAIN, 16);
        font2 = new Font("Tahoma", Font.BOLD, 25);
        lb1 = new JLabel("Please fill out the complaint form", JLabel.CENTER);
        lb1.setFont(font2);
        lb2 = new JLabel("Complaint types", JLabel.CENTER);
        lb3 = new JLabel("Location", JLabel.CENTER);
        lb4 = new JLabel("Date (MM/DD/YYYY)", JLabel.CENTER);
        lb5 = new JLabel("Details", JLabel.CENTER);
        lb6 = new JLabel("Image", JLabel.CENTER);

        cb = new JComboBox();
        cb.addItem("---PLEASE SELECT---");
        cb.addItem("Deserted area");
        cb.addItem("Defective area");
        cb.addItem("Illegal area");
        cb.addItem("Mischief");
        cb.addItem("Traffic offenders");
        cb.addItem("Non-standard products");
        cb.addItem("Fraud/Corruption");
        cb.addItem("Other");
        cb.setFont(font);
        cb.setPreferredSize(new Dimension(0, 10));
        tf1 = new JTextField(30);
        tf1.setFont(font);
        tf1.setMaximumSize(new Dimension(tf1.getMaximumSize().width, 20));
        tf2 = new JTextField(30);

        tf2.setFont(font);
        tf2.setMaximumSize(new Dimension(tf1.getMaximumSize().width, 20));
        
        ta = new JTextArea(3, 10);
        ta.setFont(font);
        submitBtn = new JButton("Submit");

        mainPanel = new JPanel();
        typePanel = new JPanel();
        locationPanel = new JPanel();
        datePanel = new JPanel();
        detailPanel = new JPanel();
        p7 = new JPanel();
        b1 = Box.createVerticalBox();
        b2 = Box.createVerticalBox();
        b3 = Box.createVerticalBox();
        b4 = Box.createVerticalBox();

        new JPanel();
        p9 = new JPanel();
        new JPanel();
        new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        typePanel.setLayout(new GridLayout(1, 2));
        locationPanel.setLayout(new GridLayout(1, 2));
        datePanel.setLayout(new GridLayout(1, 2));
        detailPanel.setLayout(new GridLayout(1, 2));

        p9.setLayout(new BorderLayout());

        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        typePanel.setBorder(new EmptyBorder(10, 10, 0, 50));
        locationPanel.setBorder(new EmptyBorder(10, 10, 10, 50));
        datePanel.setBorder(new EmptyBorder(10, 10, 10, 50));
        detailPanel.setBorder(new EmptyBorder(0, 10, 0, 50));
        p7.setBorder(new EmptyBorder(10, 10, 10, 10));
        p9.setBorder(new EmptyBorder(20, 10, 10, 10));

        typePanel.add(lb2);
        b1.add(Box.createVerticalGlue());
        b1.add(cb);
        b1.add(Box.createVerticalGlue());
        typePanel.add(b1);

        locationPanel.add(lb3);
        b2.add(Box.createVerticalGlue());
        b2.add(tf1);
        b2.add(Box.createVerticalGlue());
        locationPanel.add(b2);

        datePanel.add(lb4);
        b3.add(Box.createVerticalGlue());
        b3.add(tf2);
        b3.add(Box.createVerticalGlue());
        datePanel.add(b3);

        detailPanel.add(lb5);
        b4.add(Box.createVerticalGlue());
        
        ta.setLineWrap(true);
        scroll = new JScrollPane(ta);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        b4.add(scroll);
        b4.add(Box.createVerticalGlue());
        detailPanel.add(b4);

        p7.add(submitBtn);

        mainPanel.add(typePanel);
        mainPanel.add(locationPanel);
        mainPanel.add(datePanel);
        mainPanel.add(detailPanel);

        p9.add(lb1, BorderLayout.NORTH);
        p9.add(mainPanel, BorderLayout.CENTER);
        
        this.add(p9, BorderLayout.CENTER);
        this.add(p7, BorderLayout.SOUTH);
    }
    
    public JComboBox getComboBox(){return this.cb;}
    public JTextField getLocationTextField(){return this.tf1;}
    public JTextField getDateTextField(){return this.tf2;}
    public JTextArea getDetailTextArea(){return this.ta;}    
    public JButton getSummitBtn(){return this.submitBtn;}
    
    public void reset(){
        this.cb.setSelectedItem("---PLEASE SELECT---");
        this.tf1.setText("");
        this.tf2.setText("");
        this.ta.setText("");
    }
}
