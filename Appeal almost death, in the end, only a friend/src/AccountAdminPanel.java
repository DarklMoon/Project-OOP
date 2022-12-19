import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.net.URL;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class AccountAdminPanel extends JPanel{
    private JPanel tablePanel, profilePanel, wrapPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel picture, emailLabel, title;
    public static final Color COLOR = new Color(143,211,211);
    
    public AccountAdminPanel(){
        
        tablePanel = new JPanel(new BorderLayout());
        table = new JTable(new TableModel()){
             public String getToolTipText( MouseEvent e ){
                int row = rowAtPoint( e.getPoint() );   
                int column = columnAtPoint( e.getPoint() );
                Object value = getValueAt(row, column);
                return value == null ? null : value.toString();
            }};
        
        table.setPreferredScrollableViewportSize(new Dimension(700, 5));
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        table.getTableHeader().setBackground(Color.decode("#FF9B4A"));
        
        initColumn(table, table.getColumnModel().getColumn(7));
        //Add Button viewImage in Column 5,6
        table.getColumnModel().getColumn(6).setCellRenderer(new AccountAdminPanel.ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new AccountAdminPanel.ButtonEditor(new JTextField()));
        
        table.getColumnModel().getColumn(5).setCellRenderer(new AccountAdminPanel.ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new AccountAdminPanel.ButtonEditor(new JTextField()));

        table.setAutoCreateRowSorter(true);
        
        scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(COLOR);
        tablePanel.add(scrollPane);
        tablePanel.setBorder(new EmptyBorder(50,20,30,20));
        
        ImageIcon icon = null;
        URL imageURL = this.getClass().getResource("user.png");
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        picture = new JLabel(icon);
        emailLabel = new JLabel("OOP@hotmail.com", SwingConstants.CENTER);
        title = new JLabel("ADMIN", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 32));
        
        profilePanel = new JPanel(new BorderLayout());
        profilePanel.setBorder(new EmptyBorder(80,0,100,0));
        profilePanel.add(title, BorderLayout.NORTH);
        profilePanel.add(picture, BorderLayout.CENTER);
        profilePanel.add(emailLabel, BorderLayout.SOUTH);
        
        wrapPanel = new JPanel(new BorderLayout());
        wrapPanel.add(tablePanel, BorderLayout.EAST);
        wrapPanel.add(profilePanel, BorderLayout.WEST);
        wrapPanel.setBorder(new EmptyBorder(20,40,10,0));
        
        this.setLayout(new BorderLayout());
        this.add(wrapPanel, BorderLayout.CENTER);
        
    }
    
    
    
    class ButtonRenderer extends JButton implements  TableCellRenderer{

        public ButtonRenderer() {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
            boolean selected, boolean focused, int row, int col) {
            if(col == 5){
                setText((obj==null) ? "":"View");
            }
            else if(col == 6){
                setText((obj==null) ? "":"View");
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor{
        protected JButton btn;
        private String detail, pathImage, location, username;
        private Boolean clicked, clickedDetail;
        private JFrame frame;
        private JPanel locationPanel, detailPanel;
        private JLabel imageShow, locationLabel, detailLabel;
        private JScrollPane locationScrollPane, detailScrollPane;
        private JTextArea detailArea, locationArea;

        public ButtonEditor(JTextField txt) {
        super(txt);

        btn=new JButton();
        btn.setOpaque(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {
            if(col == 5){
                clicked = true;
                clickedDetail = true;
                username=(obj==null) ? "":table.getModel().getValueAt(row, col-4).toString();
                btn.setText("View"); 
            }
            else if(col == 6){
                clicked = true;
                clickedDetail = false;
                username=(obj==null) ? "":table.getModel().getValueAt(row, col-5).toString();
                btn.setText("View"); 
            }
            detail=(obj==null) ? "":obj.toString();
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            if((clicked == true)&&(clickedDetail == false)){
                pathImage = "user.png";
                viewImage(username, pathImage);
            }
            else if((clicked == true)&&(clickedDetail == true)){
                location = "Location0123456789";
                viewDetail(username,location, detail);
            }
            
            clicked=false;
            clickedDetail=false;
            return new String(username);
        }

        @Override
        public boolean stopCellEditing() {
            clicked=false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
  
        public void viewDetail(String username, String location, String detail){
            frame = new JFrame("Detail User: " + username);
            scrollPane = new JScrollPane();
            locationLabel = new JLabel("Location");
            locationArea = new JTextArea(location,5,5);
            detailLabel = new JLabel("Detail");
            detailArea = new JTextArea(detail,10,30);
            locationPanel = new JPanel();
            detailPanel = new JPanel();
            
            locationLabel.setFont(new Font("Verdana", Font.BOLD, 20));
            detailLabel.setFont(new Font("Verdana", Font.BOLD, 20));
            locationArea.setFont(new Font("Verdana", Font.PLAIN, 14));
            detailArea.setFont(new Font("Verdana", Font.PLAIN, 14));
            locationArea.setEditable(false);
            detailArea.setEditable(false);
            locationArea.setLineWrap(true);
            detailArea.setLineWrap(true);
            locationPanel.setLayout(new BorderLayout());
            detailPanel.setLayout(new BorderLayout());
            
            locationScrollPane = new JScrollPane(locationArea);
            locationScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
            detailScrollPane = new JScrollPane(detailArea);
            detailScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
                        
            locationPanel.add(locationLabel, BorderLayout.NORTH);
            locationPanel.add(locationScrollPane, BorderLayout.CENTER);
            locationPanel.setBorder(new EmptyBorder(10,40,10,40));
            
            detailPanel.add(detailLabel, BorderLayout.NORTH);
            detailPanel.add(detailScrollPane, BorderLayout.CENTER);
            detailPanel.setBorder(new EmptyBorder(0,40,20,40));
            
            frame.setLayout(new BorderLayout());
            frame.add(locationPanel, BorderLayout.NORTH);
            frame.add(detailPanel, BorderLayout.CENTER);
                        
            frame.setSize(500,500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        }
        
        public void viewImage(String image, String path){
            frame = new JFrame("Image User: " + image);
            ImageIcon icon = null;
            URL imageURL = this.getClass().getResource(path);
            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
            }     
            imageShow = new JLabel(icon);
            frame.add(imageShow);
            frame.setSize(1000,800);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            System.out.println(image);
        }
    }
    
    private void initColumn(JTable table, TableColumn objColumn) {
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(175);
        table.getColumnModel().getColumn(5).setPreferredWidth(75);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        objColumn.setCellRenderer(renderer);
        renderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( renderer );
        table.getColumnModel().getColumn(4).setCellRenderer( renderer );
    }
   
    class TableModel extends AbstractTableModel {
        private String[] columnNames = {"No.",
                                        "USERNAME",
                                        "TYPE",
                                        "EMAIL",
                                        "DATE",
                                        "DETAIL",
                                        "IMAGES",
                                        "STATUS"};
        private Object[][] data = {
	    {"1","Username01","Deserted area",
	     "Email01@mail.com", "14/12/22","lorem...","Username01","Complete"},
	    {"2","Username02", "Defective area",
	     "Email02@mail.com", "14/12/22","lorem...","Username02", "Failed"},
	    {"3","Username03", "Illegal area",
	     "Email03@mail.com", "14/12/22","lorem...","Username03", "Complete"},
	    {"4","Username04", "Mischief",
	     "Email04@mail.com", "14/12/22","lorem...","Username04", "Complete"},
	    {"5","Username05", "Traffic offenders",
	     "Email05@mail.com", "14/12/22","lorem...","Username05", "Failed"},
            {"6","Username06", "Non-standard products",
	     "Email06@mail.com", "14/12/22","lorem...","Username06", "Failed"},
            {"7","Username07", "Fraud/Corruption",
	     "Email07@mail.com", "14/12/22","lorem...","Username07",  "Complete"},
            {"8","Username08", "Other",
	     "Email08@mail.com", "14/12/22","lorem...","Username08", "Complete"},
            {"9","Username09", "Other",
	     "Email09@mail.com", "14/12/22","lorem...","Username09", "Complete"}
        };

        public final Object[] longValues = {"Jane", "Kathy",
                                            "None of the above",
                                            new Integer(20), Boolean.TRUE};

        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            if ((col < 5) || (col == 7)){
                return false;
            } else {
                return true;
            }
        }
        
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
    
}
