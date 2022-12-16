import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import static javax.swing.ScrollPaneConstants.*;

public class ReportPanel extends JPanel{

    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private JButton submitBtn, addBtn;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lbC;
    private JTextField tf1, tf2, tf3;
    private JComboBox cb;
    private JTextArea ta;
    private Box b1, b2, b3, b4, b5, b6;
    private Font font, font2;
    private JScrollPane scroll;
    public static final Color VERY_LIGHT_RED = new Color(51, 204, 255);

    public ReportPanel() {
        this.setLayout(new BorderLayout());

        font = new Font("Tahoma", Font.PLAIN, 16);
        font2 = new Font("Tahoma", Font.PLAIN, 20);
        lb1 = new JLabel("Please fill out the complaint form", JLabel.CENTER);
        lb1.setFont(font2);
        lb2 = new JLabel("Complaint types", JLabel.CENTER);
        lb3 = new JLabel("Location", JLabel.CENTER);
        lb4 = new JLabel("Date (MM/DD/YYYY)", JLabel.CENTER);
        lb5 = new JLabel("Details", JLabel.CENTER);
        lb6 = new JLabel("Image", JLabel.CENTER);
//        lb4 = new JLabel("", JLabel.CENTER);
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
//        cb.setPreferredSize(tf1.getPreferredSize());
        tf2.setFont(font);
        tf2.setMaximumSize(new Dimension(tf1.getMaximumSize().width, 20));
        tf3 = new JTextField(30);
        tf3.setFont(font);
        tf3.setMaximumSize(new Dimension(tf1.getMaximumSize().width, 20));
        ta = new JTextArea(3, 10);
        ta.setFont(font);
        submitBtn = new JButton("Submit");
        addBtn = new JButton("Add Image");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        b1 = Box.createVerticalBox();
        b2 = Box.createVerticalBox();
        b3 = Box.createVerticalBox();
        b4 = Box.createVerticalBox();
        b5 = Box.createVerticalBox();
//        b6 = Box.createVerticalBox();
        p8 = new JPanel();
        p9 = new JPanel();
        p10 = new JPanel();
        p11 = new JPanel();
        p1.setLayout(new GridLayout(5, 1));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        p4.setLayout(new GridLayout(1, 2));
        p5.setLayout(new GridLayout(1, 2));
        p6.setLayout(new GridLayout(1, 2));
//        p7.setLayout(new BoxLayout(p7, BoxLayout.Y_AXIS));
//        p8.setLayout(new BorderLayout());
        p9.setLayout(new BorderLayout());
//        p10.setLayout(new BorderLayout());
//        p11.setLayout(new BorderLayout());
        p1.setBorder(new EmptyBorder(30, 30, 30, 30));
        p2.setBorder(new EmptyBorder(10, 10, 0, 50));
        p3.setBorder(new EmptyBorder(10, 10, 10, 50));
        p4.setBorder(new EmptyBorder(10, 10, 10, 50));
        p5.setBorder(new EmptyBorder(0, 10, 0, 50));
        p6.setBorder(new EmptyBorder(10, 10, 10, 50));
        p7.setBorder(new EmptyBorder(10, 10, 10, 10));
        p9.setBorder(new EmptyBorder(20, 10, 10, 10));
//        cb.setAlignmentY(Component.CENTER_ALIGNMENT);
//        cb.setMaximumSize(cb.getPreferredSize());
        p2.add(lb2);
        b1.add(Box.createVerticalGlue());
        b1.add(cb);
        b1.add(Box.createVerticalGlue());
        p2.add(b1);

        p3.add(lb3);
        b2.add(Box.createVerticalGlue());
        b2.add(tf1);
        b2.add(Box.createVerticalGlue());
        p3.add(b2);

        p4.add(lb4);
        b3.add(Box.createVerticalGlue());
        b3.add(tf2);
        b3.add(Box.createVerticalGlue());
        p4.add(b3);

        p5.add(lb5);
        b4.add(Box.createVerticalGlue());
        
        ta.setLineWrap(true);
        scroll = new JScrollPane(ta);
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        b4.add(scroll);
        b4.add(Box.createVerticalGlue());
        p5.add(b4);

        p6.add(lb6);
        b5.add(Box.createVerticalGlue());
        b5.add(addBtn);
//        b5.add(Box.createVerticalGlue());
        p6.add(b5);

        p7.add(submitBtn);

//        p8.add(lb1);

//        p1.add(p8);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        p1.add(p6);

        p9.add(lb1, BorderLayout.NORTH);
        p9.add(p1, BorderLayout.CENTER);
        
        this.add(p9, BorderLayout.CENTER);
        this.add(p7, BorderLayout.SOUTH);
    }

    /*@Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(addBtn)) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame); // fr คือ ตัวแปรออปเจ็ค JFrame
            File f = fc.getSelectedFile();

        }
    }*/
}//top, left, bottom, and right
//สิ่งที่ควรมีหน้า Report :
//- เลือกประเภทร้องเรียน (ใช้ ComboBox เลือกประเภท)
//- สถานที่ร้องเรียน (TextField)
//- วันที่เกิดเหตุ (SimpleDateFormat https://www.geeksforgeeks.org/simpledateformat-parse-method-in-java-with-examples/)
//- รายละเอียดเรื่องที่ร้องเรียน (TextArea)
//- รูปภาพหลักฐาน (ใส่ไม่ได้ไม่เป็นอะไร) (FileChooser) 
