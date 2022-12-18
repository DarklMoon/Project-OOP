import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.RenderingHints;


public class ViewAccountAdmin {
    private JFrame frame;
    private JPanel menuPanel, tablePanel, profilePanel;
    private JButton iconBtn, reportBtn, accountBtn, settingBtn;
    private JTable table;
    private JScrollPane scrollPane;
    private JTableHeader header;
    private JLabel Pic, Email;
    private Object selectedColumn = null;
    private boolean DEBUG = false;
    public static final Color COLOR = new Color(143,211,211);
    public ViewAccountAdmin(){
        frame = new JFrame("Call Sing");
        frame.setLayout(new BorderLayout());
        
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
        
        settingBtn = new JButton("Settings");
        settingBtn.setBackground(new Color(85,189,96));
        settingBtn.setOpaque(true);
        menuPanel.add(settingBtn);
        
        tablePanel = new JPanel(new BorderLayout());
        table = new JTable(new TableModel());
        
        table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        
        header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader h = (JTableHeader) e.getSource();
                int i = h.columnAtPoint(e.getPoint());
                Object o = h.getColumnModel().getColumn(i).getHeaderValue();
                if (i < 0) {
                    selectedColumn = null;
                    return;
                }
                selectedColumn = o;
                h.requestFocusInWindow();
            }
        });
        
        TableCellRenderer hr = table.getTableHeader().getDefaultRenderer();
        header.setDefaultRenderer(new TableCellRenderer() {
            private JLabel lbl;
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, 
                    int row, int column) {
                if (selectedColumn == value) {
                    lbl = (JLabel) hr.getTableCellRendererComponent(table, value, 
                            true, true, row, column);
                    lbl.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createEmptyBorder(1, 1, 1, 1), 
                            BorderFactory.createLineBorder(Color.red, 1)));
                    lbl.setHorizontalAlignment(SwingConstants.LEFT);
                    lbl.setBackground(lbl.getBackground());
                } else {
                    lbl = (JLabel) hr.getTableCellRendererComponent(table, value, 
                            false, false, row, column);
                    lbl.setBorder(BorderFactory.createCompoundBorder(
                            lbl.getBorder(), 
                            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
                    lbl.setHorizontalAlignment(SwingConstants.CENTER);
                    lbl.setBackground(Color.ORANGE);
                }
                if (column == 5) {
                    lbl.setForeground(Color.red);
                } else {
                    lbl.setForeground(header.getForeground());
                }
                return lbl;
            }
        });
        
        scrollPane = new JScrollPane(table);
        
        initColumnSizes(table);
        setUpSportColumn(table, table.getColumnModel().getColumn(5));
        scrollPane.getViewport().setBackground(COLOR);
        tablePanel.add(scrollPane);
        tablePanel.setBorder(new EmptyBorder(50,20,30,20));
        
        ImageIcon icon = null;
        URL imageURL = this.getClass().getResource("profile.png");
        System.out.println(getClass().getResource("Account.java"));
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        Pic = new JLabel(icon);
        Pic.setBounds(250, 350, 520, 110);
        Email = new JLabel("OOP@hotmail.com");
        Email.setBounds(100, -50, 100, 100);
        profilePanel = new JPanel(new GridLayout(2, 1));
        profilePanel.add(Pic);
        profilePanel.add(Email);
        //-Add Panel-
        
        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.EAST);
        frame.add(profilePanel, BorderLayout.WEST);
        
        frame.setVisible(true);
        frame.setSize(1024,640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    private void initColumnSizes(JTable table) {
        TableModel model = (TableModel)table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
            table.getTableHeader().getDefaultRenderer();

        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            comp = headerRenderer.getTableCellRendererComponent(
                                 null, column.getHeaderValue(),
                                 false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;

            comp = table.getDefaultRenderer(model.getColumnClass(i)).
                             getTableCellRendererComponent(
                                 table, longValues[i],
                                 false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;

            if (DEBUG) {
                System.out.println("Initializing width of column "
                                   + i + ". "
                                   + "headerWidth = " + headerWidth
                                   + "; cellWidth = " + cellWidth);
            }

            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
        table.getColumnModel().getColumn(1).setPreferredWidth(185);
        table.getColumnModel().getColumn(2).setPreferredWidth(105);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(325);
        table.getColumnModel().getColumn(5).setPreferredWidth(85);

        
    }
    
    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {

        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
        
        renderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( renderer );
        table.getColumnModel().getColumn(3).setCellRenderer( renderer );
        
    }
    
    
    class TableModel extends AbstractTableModel {
        private String[] columnNames = {"No.",
                                        "TYPE",
                                        "LOCATION",
                                        "DATE",
                                        "DETAIL",
                                        "STATUS"};
        private Object[][] data = {
	    {"1", "Deserted area",
	     "Snowboarding", "14/12/22","lore...","Pending"},
	    {"2", "Defective area",
	     "Rowing", "14/12/22","lorem...", "Pending"},
	    {"3", "Illegal area",
	     "Knitting", "14/12/22","lorem...", "Pending"},
	    {"4", "Mischief",
	     "Speed reading", "14/12/22","lorem...", "Pending"},
	    {"5", "Traffic offenders",
	     "Pool", "14/12/22","lorem...", "Pending"},
            {"6", "Non-standard products",
	     "Pool", "14/12/22","lorem...", "Pending"},
            {"7", "Fraud/Corruption",
	     "Pool", "14/12/22","lorem...",  "Pending"},
            {"8", "Other",
	     "Pool", "14/12/22","lorem...", "Pending"},
            {"9", "Other",
	     "Pool", "14/12/22","lorem...", "Pending"}
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
            if (col < 5) {
                return false;
            } else {
                return true;
            }
        }
        
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
    
    public static void main(String[] args) {
            new ViewAccountAdmin();
        }
}

