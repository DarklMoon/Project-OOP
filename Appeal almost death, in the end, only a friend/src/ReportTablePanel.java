import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.border.EmptyBorder;

public class ReportTablePanel extends JPanel{
    private JLabel title,label;
    private JButton updateBtn;
    private JPanel header,innerPanel;
    
    private JTable table;
    private JScrollPane scrollPane;
    private TableModel tableModel;
    public static final Color COLOR = new Color(143,211,211);
    
    public ReportTablePanel(){
        
        title = new JLabel("Report Table", SwingConstants.CENTER);
        title.setFont(new Font("Sarabun", Font.BOLD, 32));
        title.setBackground(new Color(139, 188, 204));
        title.setOpaque(true);
        title.setBorder(new EmptyBorder(-10,0,10,0));
        
        tableModel = new TableModel();
        
        table = new JTable(tableModel){
             public String getToolTipText( MouseEvent e ){
                int row = rowAtPoint( e.getPoint() );   
                int column = columnAtPoint( e.getPoint() );
                Object value = getValueAt(row, column);
                return value == null ? null : value.toString();
            }};
        
        label = new JLabel("No data",SwingConstants.CENTER);
        label.setFont(new Font("Sarabun", Font.BOLD, 30));
        label.setForeground(Color.RED);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        table.getTableHeader().setBackground(Color.decode("#FF9B4A"));
        
        initColumnSize(table);
        scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(COLOR);
        
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
        table.getColumnModel().getColumn(7).setCellRenderer(renderer);
        
        updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Sarabun", Font.BOLD, 13));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBackground(new Color(76, 103, 147));
        innerPanel = new JPanel(new FlowLayout());
        innerPanel.setBackground(new Color(139, 188, 204));
        innerPanel.add(updateBtn);
        innerPanel.setBorder(new EmptyBorder(0,20,0,0));
        header = new JPanel(new FlowLayout());
        header.add(title);
        header.add(innerPanel);
        header.setBorder(new EmptyBorder(0,50,0,0));
        header.setBackground(new Color(139, 188, 204));

        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setBorder(new EmptyBorder(30,20,20,20));
         this.setBackground(new Color(139, 188, 204));
    }
    
    public JTable getTable(){return this.table;}
    public void setNoData(){label.setSize(970,400); table.add(label);}
    public TableModel getTableModel(){return this.tableModel;}
    public JButton getUpdateBtn(){return this.updateBtn;}
    
    class ButtonRenderer extends JButton implements  TableCellRenderer{

        public ButtonRenderer() {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
            boolean selected, boolean focused, int row, int col) {
            if(col == 6){
                setText((obj==null) ? "":"View Detail");
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor{
        protected JButton btn;
        private String detail, location, username;
        private Boolean clicked, clickedDetail;
        private JFrame frame;
        private JPanel locationPanel, detailPanel;
        private JLabel locationLabel, detailLabel;
        private JScrollPane locationScrollPane, detailScrollPane;
        private JTextArea detailArea, locationArea;

        public ButtonEditor(JTextField txt) {
            super(txt);
            btn=new JButton();
            btn.setOpaque(true);
            btn.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {fireEditingStopped();}
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {
            if(col == 6){
                clicked = true;
                clickedDetail = true;
                username=table.getModel().getValueAt(row, col-5).toString();
                location = table.getModel().getValueAt(row, col-1).toString();
                detail = table.getModel().getValueAt(row, col).toString();
            }
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            if((clicked == true)&&(clickedDetail == true)){
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
    }
    
    private void initColumnSize(JTable table) {
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
        table.getColumnModel().getColumn(3).setPreferredWidth(175);
        table.getColumnModel().getColumn(5).setPreferredWidth(75);
    }
 
    class TableModel extends AbstractTableModel {
        private String[] columnNames = {"ID",
                                        "USERNAME",
                                        "TYPE",
                                        "EMAIL",
                                        "DATE",
                                        "LOCATION",
                                        "DETAIL",
                                        "STATUS"};
        
        private Object[][] data = new Object[0][8];

        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return data.length;}
        public String getColumnName(int col) {return columnNames[col];}
        public Object getValueAt(int row, int col) {return data[row][col];}
        public Class getColumnClass(int c) {return getValueAt(0, c).getClass();}

        public boolean isCellEditable(int row, int col) {
            if (col < 6) {return false;} 
            else {return true;}
        }
        
        public Object[][] getData(){return this.data;}
        public void setData(Object[][] obj){this.data = obj;}
    }
}


