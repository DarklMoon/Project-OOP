import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class MainAdminPage {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn;
    private ChartsAdminPanel chartAdminPanel;
    private ReportTablePanel reportTable;
    private AccountAdminPanel accountAdmin;
    private SettingsAdminPanel settingsPanel;
    
    public MainAdminPage(){
        frame = new JFrame("Call Sing [Admin]");
        frame.setLayout(new BorderLayout());
        
        chartAdminPanel = new ChartsAdminPanel();
        reportTable = new ReportTablePanel();
        accountAdmin = new AccountAdminPanel();
        settingsPanel = new SettingsAdminPanel();
                
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,4));
        menuPanel.setPreferredSize(new Dimension(800,100));
        
        iconBtn = new JButton("Call Sing");
        iconBtn.setFont(new Font("Verdana", Font.BOLD, 24));
        iconBtn.setBackground(new Color(217,217,217));
        iconBtn.setOpaque(true);
        menuPanel.add(iconBtn);
        
        reportBtn = new JButton("Reported");
        reportBtn.setFont(new Font("Verdana", Font.BOLD, 24));
        reportBtn.setBackground(new Color(255,97,97));
        reportBtn.setOpaque(true);
        menuPanel.add(reportBtn);
        
        accountBtn = new JButton("Account");
        accountBtn.setFont(new Font("Verdana", Font.BOLD, 24));
        accountBtn.setBackground(new Color(111,168,255));
        accountBtn.setOpaque(true);
        menuPanel.add(accountBtn);
        
        settingBtn = new JButton("Settings");
        settingBtn.setFont(new Font("Verdana", Font.BOLD, 24));
        settingBtn.setBackground(new Color(85,189,96));
        settingBtn.setOpaque(true);
        menuPanel.add(settingBtn);
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(chartAdminPanel, BorderLayout.CENTER);
        
        frame.setVisible(false); //set true for display
        frame.setSize(1024,640);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getFrame(){return this.frame;}    
    
    public JButton getIconButton(){return this.iconBtn;}
    public JButton getReportButton(){return this.reportBtn;}
    public JButton getAccountButton(){return this.accountBtn;}
    public JButton getSettingsButton(){return this.settingBtn;}
      
    public void setMainPanel(){
        reportTable.setVisible(false);
        accountAdmin.setVisible(false);
        settingsPanel.setVisible(false);
        chartAdminPanel.setVisible(true);
        frame.revalidate();
    }
    
    public void setReportTablePanel(){
        frame.add(reportTable, BorderLayout.CENTER);
        reportTable.setVisible(true);
        chartAdminPanel.setVisible(false);
        accountAdmin.setVisible(false);
        settingsPanel.setVisible(false);
        frame.revalidate();
    }
    
    public void setAccountAdminPanel(){
        frame.add(accountAdmin, BorderLayout.CENTER);
        accountAdmin.setVisible(true);
        reportTable.setVisible(false);
        chartAdminPanel.setVisible(false);
        settingsPanel.setVisible(false);
        frame.revalidate();
    } 
        
    public void setSettingsPanel(){
        frame.add(settingsPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(true);
        chartAdminPanel.setVisible(false);
        reportTable.setVisible(false);
        accountAdmin.setVisible(false);
        frame.revalidate();
    }
    
    public void exit(){
        System.exit(0);
    }
    
    public ChartsAdminPanel getChartsPanel(){return this.chartAdminPanel;}
    public SettingsAdminPanel getSettingsPanel(){return this.settingsPanel;}
}
    
