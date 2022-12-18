import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class MainPage {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton iconBtn, reportBtn, accountBtn, settingsBtn;
    private SettingsPanel settingsPanel;
    private ChartsPanel chartPanel;
    private ReportPanel reportPanel;

    public MainPage(){
        frame = new JFrame("Call Sing");
        frame.setLayout(new BorderLayout());
        
        settingsPanel = new SettingsPanel();
        chartPanel = new ChartsPanel();
        reportPanel = new ReportPanel();
        
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
        frame.add(settingsPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(true);
        chartPanel.setVisible(false);
        reportPanel.setVisible(false);
        frame.revalidate();
    }
    
    public void setMainPanel(){
        settingsPanel.setVisible(false);
        chartPanel.setVisible(true);
        reportPanel.setVisible(false);
        frame.revalidate();
    }
    
    public void setReportPanel(){
        frame.add(reportPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(false);
        chartPanel.setVisible(false);
        reportPanel.setVisible(true);
        frame.revalidate();
    }
    
    public SettingsPanel getSettingsPanel(){return this.settingsPanel;}
    public ReportPanel getReportPanel(){return this.reportPanel;}
}
    
