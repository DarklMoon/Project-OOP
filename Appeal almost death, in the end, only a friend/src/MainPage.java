import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
/*import java.awt.Font;
import java.awt.SystemColor;*/
import javax.swing.*;
/*import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;

import org.jfree.data.category.DefaultCategoryDataset;*/

public class MainPage {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingsBtn;
    private SettingsPanel settingsPanel;
    private ChartsPanel chartPanel;
    public static final Color VERY_LIGHT_RED = new Color(51,204,255);
    
    public MainPage(){
        frame = new JFrame("Call Sing");
        frame.setLayout(new BorderLayout());
        
        settingsPanel = new SettingsPanel();
        chartPanel = new ChartsPanel();
        
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,4));
        menuPanel.setPreferredSize(new Dimension(800,100));
        
        iconBtn = new JButton("Call Sing");
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
        
        settingsBtn = new JButton("Settings");
        settingsBtn.setBackground(new Color(85,189,96));
        settingsBtn.setOpaque(true);
        menuPanel.add(settingsBtn);
        
        /*DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(80, "Marks", "พื้นที่เปลี่ยว");
        dataset.setValue(50, "Marks", "พื้นที่ชำรุด");
        dataset.setValue(75, "Marks", "พื้นที่ผิดกฎหมาย");
        dataset.setValue(95, "Marks", "อบายมุข");
        dataset.setValue(10, "Marks", "ผู้กระทำผิดทางจราจร");
        dataset.setValue(45, "Marks", "สินค้าไม่ได้มาตรฐาน");
        dataset.setValue(35, "Marks", "ทุจริต/คอรัปชั่น");
        dataset.setValue(70, "Marks", "อื่นๆ");
        JFreeChart chart = ChartFactory.createBarChart3D("กราฟแสดงจำนวนการร้องเรียน", "ประเภทของการร้องเรียน", "จำนวนครั้ง", dataset, PlotOrientation.VERTICAL, false, true, false);
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
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot= chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA");
        plot.setNoDataMessageFont(new Font("Arial", Font.BOLD, 30));
        plot.setNoDataMessagePaint(Color.RED);
        ChartPanel cp = new ChartPanel(chart);
        chartPanel = new JPanel();
        chartPanel.setLayout(new java.awt.BorderLayout());
        chartPanel.add(cp,BorderLayout.CENTER);
        chartPanel.validate();*/
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(chartPanel, BorderLayout.CENTER);
        
        frame.setVisible(false);
        frame.setSize(1024,640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getFrame(){return this.frame;}    
    
    public JButton getIconButton(){return this.iconBtn;}
    public JButton getReportButton(){return this.reportBtn;}
    public JButton getAccountButton(){return this.accountBtn;}
    public JButton getSettingsButton(){return this.settingsBtn;}
    
    public void setSettingsPanel(){
        settingsPanel = new SettingsPanel();
        frame.add(settingsPanel);
        frame.revalidate();
    }
    
    public void setMainPanel(){
        chartPanel = new ChartsPanel();
        frame.add(chartPanel);
        frame.revalidate();
    }
}
    
