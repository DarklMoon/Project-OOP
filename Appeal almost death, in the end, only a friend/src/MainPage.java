import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;

import org.jfree.data.category.DefaultCategoryDataset;

public class MainPage {
    private JFrame frame;
    private JPanel menuPanel, chartPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn;
    public static final Color VERY_LIGHT_RED = new Color(51,204,255);
    
    public MainPage(){
        frame = new JFrame("Appname");
        frame.setLayout(new BorderLayout());
        
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,4));
        menuPanel.setPreferredSize(new Dimension(800,100));
        
        iconBtn = new JButton("Appname");
        iconBtn.setBackground(new Color(217,217,217));
        iconBtn.setOpaque(true);
        menuPanel.add(iconBtn);
        
        reportBtn = new JButton("Report");
        reportBtn.setBackground(new Color(255,97,97));
        reportBtn.setOpaque(true);
        menuPanel.add(reportBtn);
        
        accountBtn = new JButton("Account");
        accountBtn.setBackground(new Color(111,168,255));
        accountBtn.setOpaque(true);
        menuPanel.add(accountBtn);
        
        settingBtn = new JButton("Settings");
        settingBtn.setBackground(new Color(85,189,96));
        settingBtn.setOpaque(true);
        menuPanel.add(settingBtn);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(80, "Marks", "People1");
        dataset.setValue(50, "Marks", "People2");
        dataset.setValue(75, "Marks", "People3");
        dataset.setValue(95, "Marks", "People4");
        dataset.setValue(10, "Marks", "People5");
        dataset.setValue(45, "Marks", "People6");
        dataset.setValue(35, "Marks", "People7");
        dataset.setValue(70, "Marks", "People8");
        dataset.setValue(105, "Marks", "People9");
        JFreeChart chart = ChartFactory.createBarChart3D("People Chart", "People Name", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.BLACK); 
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.WHITE);
        
        p = (CategoryPlot)chart.getPlot();
        p.setBackgroundPaint(SystemColor.inactiveCaption);//change background color

    //set  bar chart color
        ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());

        BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, VERY_LIGHT_RED);
        
        ChartPanel cp = new ChartPanel(chart);
        chartPanel = new JPanel();
        chartPanel.setLayout(new java.awt.BorderLayout());
        chartPanel.add(cp,BorderLayout.CENTER);
        chartPanel.validate();
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(chartPanel, BorderLayout.CENTER);
        
        frame.setVisible(false);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getFrame(){return this.frame;}    
    
}
    
