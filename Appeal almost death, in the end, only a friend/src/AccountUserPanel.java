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

public class AccountUserPanel extends JPanel {
    private JPanel tablePanel, profilePanel, wrapPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel picture, emailLabel, title;
    public static final Color COLOR = new Color(143,211,211);
    
    public AccountUserPanel(){       
        tablePanel = new JPanel(new BorderLayout());
        table = new JTable(new TableModel()){
             public String getToolTipText( MouseEvent e ){
                int row = rowAtPoint( e.getPoint() );   
                int column = columnAtPoint( e.getPoint() );
                Object value = getValueAt(row, column);
                return value == null ? null : value.toString();
            }};
        
        table.setPreferredScrollableViewportSize(new Dimension(650, 5));
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        table.getTableHeader().setBackground(Color.decode("#FF9B4A"));
        
        initColumn(table, table.getColumnModel().getColumn(5));
        //Add Button viewImage in Column 3,4
        table.getColumnModel().getColumn(4).setCellRenderer(new AccountUserPanel.ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new AccountUserPanel.ButtonEditor(new JTextField()));
        
        table.getColumnModel().getColumn(3).setCellRenderer(new AccountUserPanel.ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new AccountUserPanel.ButtonEditor(new JTextField()));

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
        title = new JLabel("Username", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 32));
        
        profilePanel = new JPanel(new BorderLayout());
        profilePanel.setBorder(new EmptyBorder(80,20,100,0));
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
            if(col == 3){
                setText((obj==null) ? "":"View Detail");
            }
            else if(col == 4){
                setText((obj==null) ? "":"View Image");
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
            if(col == 3){
                clicked = true;
                clickedDetail = true;
                btn.setText("View Detail"); 
            }
            else if(col == 4){
                clicked = true;
                clickedDetail = false;
                btn.setText("View Image"); 
            }
            detail=(obj==null) ? "":obj.toString();
            System.out.println(username + " " + location + " " + detail);
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            username = "Username";
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
        table.getColumnModel().getColumn(1).setPreferredWidth(125);
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(75);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        objColumn.setCellRenderer(renderer);
        renderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( renderer );
        table.getColumnModel().getColumn(2).setCellRenderer( renderer );
    }
   
    class TableModel extends AbstractTableModel {
        private String[] columnNames = {"No.",
                                        "TYPE",
                                        "DATE",
                                        "DETAIL",
                                        "IMAGES",
                                        "STATUS"};
        private Object[][] data = {
	    {"1", "Deserted area",
	     "14/12/22","lorem...","Username01","Pending"},
	    {"2", "Defective area",
	     "14/12/22","lorem...","Username02", "In progress"},
	    {"3", "Illegal area",
	     "14/12/22","lorem...","Username03", "Failed"},
	    {"4", "Mischief",
	     "14/12/22","lorem...","Username04", "Pending"},
	    {"5", "Traffic offenders",
	     "14/12/22","lorem...","Username05", "Complete"},
            {"6", "Non-standard products",
	     "14/12/22","lorem...","Username06", "Complete"},
            {"7", "Fraud/Corruption",
	     "14/12/22","lorem...","Username07",  "Complete"},
            {"8", "Other",
	     "14/12/22","lorem...","Username08", "Complete"},
            {"9", "Other",
	     "14/12/22","lorem...","Username09", "Complete"}
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
            if ((col < 3) || (col == 5)){
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

