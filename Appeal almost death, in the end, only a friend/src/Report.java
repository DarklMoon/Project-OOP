/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

/**
 *
 * @author aom
 */
public class Report {

    private JFrame frame;
    private JPanel menuPanel, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn, submitBtn;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6;
    private JTextField tf1, tf2, tf3;
    private JComboBox cb;
    private JTextArea ta;
    private Box b1, b2, b3, b4, b5;
    private Font font;
    public static final Color VERY_LIGHT_RED = new Color(51, 204, 255);

    public Report() {
        frame = new JFrame("Appname");
        frame.setLayout(new BorderLayout());

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 4));
        menuPanel.setPreferredSize(new Dimension(800, 100));

        iconBtn = new JButton("Appname");
        iconBtn.setBackground(new Color(217, 217, 217));
        iconBtn.setOpaque(true);
        menuPanel.add(iconBtn);

        reportBtn = new JButton("Report");
        reportBtn.setBackground(new Color(255, 97, 97));
        reportBtn.setOpaque(true);
        menuPanel.add(reportBtn);

        accountBtn = new JButton("Account");
        accountBtn.setBackground(new Color(111, 168, 255));
        accountBtn.setOpaque(true);
        menuPanel.add(accountBtn);

        settingBtn = new JButton("Settings");
        settingBtn.setBackground(new Color(85, 189, 96));
        settingBtn.setOpaque(true);
        menuPanel.add(settingBtn);

        font = new Font("Tahoma", Font.PLAIN, 16);
        lb1 = new JLabel("Please fill out the complaint form");
        lb2 = new JLabel("Complaint types", JLabel.CENTER);
        lb3 = new JLabel("Location", JLabel.CENTER);
        lb4 = new JLabel("Date", JLabel.CENTER);
        lb5 = new JLabel("Details", JLabel.CENTER);
        lb6 = new JLabel("Image", JLabel.CENTER);
        cb = new JComboBox();
        cb.addItem("test");
        cb.setFont(font);
        cb.setPreferredSize(new Dimension(0, 0));
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
        ta = new JTextArea(20, 30);
        ta.setFont(font);
        submitBtn = new JButton("Submit");

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
//        p9.setLayout(new BorderLayout());
//        p10.setLayout(new BorderLayout());
//        p11.setLayout(new BorderLayout());
        p1.setBorder(new EmptyBorder(30, 30, 30, 30));
        p2.setBorder(new EmptyBorder(10, 10, 10, 50));
        p3.setBorder(new EmptyBorder(10, 10, 10, 50));
        p4.setBorder(new EmptyBorder(10, 10, 10, 50));
        p5.setBorder(new EmptyBorder(10, 10, 10, 50));
        p6.setBorder(new EmptyBorder(10, 10, 10, 50));
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
        b4.add(ta);
        b4.add(Box.createVerticalGlue());
        p5.add(b4);

        p6.add(lb6);
        b5.add(Box.createVerticalGlue());
        b5.add(tf3);
        b5.add(Box.createVerticalGlue());
        p6.add(b5);

        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        p1.add(p5);
        p1.add(p6);

        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(p1, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setSize(1024, 640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Report();
    }
}
//top, left, bottom, and right
//สิ่งที่ควรมีหน้า Report :
//- เลือกประเภทร้องเรียน (ใช้ ComboBox เลือกประเภท)
//- สถานที่ร้องเรียน (TextField)
//- วันที่เกิดเหตุ (SimpleDateFormat https://www.geeksforgeeks.org/simpledateformat-parse-method-in-java-with-examples/)
//- รายละเอียดเรื่องที่ร้องเรียน (TextArea)
//- รูปภาพหลักฐาน (ใส่ไม่ได้ไม่เป็นอะไร) (FileChooser) 
