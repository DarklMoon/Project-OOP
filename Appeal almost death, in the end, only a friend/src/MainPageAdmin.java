import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class MainPageAdmin {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn;
    private ReportTablePanel reportTable;
    private ChartsAdminPanel chartAdminPanel;
    private SettingsPanel settingsPanel;
    
    public MainPageAdmin(){
        frame = new JFrame("Call Sing [Admin]");
        frame.setLayout(new BorderLayout());
        
        chartAdminPanel = new ChartsAdminPanel();
        reportTable = new ReportTablePanel();
        settingsPanel = new SettingsPanel();
                
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,4));
        menuPanel.setPreferredSize(new Dimension(800,100));
        
        iconBtn = new JButton("Call Sing");
        iconBtn.setBackground(new Color(217,217,217));
        iconBtn.setOpaque(true);
        menuPanel.add(iconBtn);
        
        reportBtn = new JButton("Reported");
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
        
       
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(chartAdminPanel, BorderLayout.CENTER);
        
        frame.setVisible(false); //set true for display
        frame.setSize(1024,640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getFrame(){return this.frame;}    
    
    public JButton getIconButton(){return this.iconBtn;}
    public JButton getReportButton(){return this.reportBtn;}
    public JButton getAccountButton(){return this.accountBtn;}
    public JButton getSettingsButton(){return this.settingBtn;}
    
    public void setReportTablePanel(){
        frame.add(reportTable, BorderLayout.CENTER);
        reportTable.setVisible(true);
        chartAdminPanel.setVisible(false);
        settingsPanel.setVisible(false);
        frame.revalidate();
    }
    
    public void setSettingsPanel(){
        frame.add(settingsPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(true);
        chartAdminPanel.setVisible(false);
        reportTable.setVisible(false);
        frame.revalidate();
    }
    
    public void setMainPanel(){
        reportTable.setVisible(false);
        settingsPanel.setVisible(false);
        chartAdminPanel.setVisible(true);
        frame.revalidate();
    }
    
}
    
