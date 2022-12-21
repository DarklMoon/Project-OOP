import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class MainPageUser {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn;
    private SettingsPanel settingsPanel;
    private ChartsPanel chartsPanel;
    private ReportPanel reportPanel;
    private AccountUserPanel accountUser;

    public MainPageUser(){
        frame = new JFrame("Call Sing");
        frame.setLayout(new BorderLayout());
        
        settingsPanel = new SettingsPanel();
        chartsPanel = new ChartsPanel();
        reportPanel = new ReportPanel();
        accountUser = new AccountUserPanel();
        
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,4));
        menuPanel.setPreferredSize(new Dimension(800,100));
        
        iconBtn = new JButton("Call Sing");
        iconBtn.setFont(new Font("Sarabun", Font.BOLD, 24));
        iconBtn.setForeground(Color.WHITE);
        iconBtn.setBackground(new Color(92, 46, 126));
        iconBtn.setOpaque(true);
        menuPanel.add(iconBtn);
        
        reportBtn = new JButton("Report");
        reportBtn.setFont(new Font("Sarabun", Font.BOLD, 24));
        reportBtn.setForeground(Color.WHITE);
        reportBtn.setBackground(new Color(76, 103, 147));
        reportBtn.setOpaque(true);
        menuPanel.add(reportBtn);
        
        accountBtn = new JButton("Account");
        accountBtn.setFont(new Font("Sarabun", Font.BOLD, 24));
        accountBtn.setForeground(Color.WHITE);
        accountBtn.setBackground(new Color(76, 103, 147));
        accountBtn.setOpaque(true);
        menuPanel.add(accountBtn);
        
        settingBtn = new JButton("Settings");
        settingBtn.setFont(new Font("Sarabun", Font.BOLD, 24));
        settingBtn.setForeground(Color.WHITE);
        settingBtn.setBackground(new Color(76, 103, 147));
        settingBtn.setOpaque(true);
        menuPanel.add(settingBtn);
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(chartsPanel, BorderLayout.CENTER);
        
        frame.setVisible(false);
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
        settingsPanel.setVisible(false);
        chartsPanel.setVisible(true);
        reportPanel.setVisible(false);
        accountUser.setVisible(false);
        frame.revalidate();
    }
    
    public void setReportPanel(){
        frame.add(reportPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(false);
        chartsPanel.setVisible(false);
        reportPanel.setVisible(true);
        accountUser.setVisible(false);
        frame.revalidate();
    }
    
        public void setAccountUserPanel(){
        frame.add(accountUser, BorderLayout.CENTER);
        settingsPanel.setVisible(false);
        chartsPanel.setVisible(false);
        reportPanel.setVisible(false);
        accountUser.setVisible(true);
        frame.revalidate();
    }
    
    public void setSettingsPanel(){
        frame.add(settingsPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(true);
        chartsPanel.setVisible(false);
        reportPanel.setVisible(false);
        accountUser.setVisible(false);
        frame.revalidate();
    }
    
    public void exit(){
        System.exit(0);
    }
    
    public ChartsPanel getChartsPanel(){return this.chartsPanel;}
    public SettingsPanel getSettingsPanel(){return this.settingsPanel;}
    public ReportPanel getReportPanel(){return this.reportPanel;}
    public AccountUserPanel getAccountUser(){return this.accountUser;}
}
    
