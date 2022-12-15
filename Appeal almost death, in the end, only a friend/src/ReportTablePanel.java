import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class ReportTablePanel extends JPanel{
    private JLabel title;
    private JTable table;
    private JScrollPane scrollPane;
    private JTableHeader header;
    private Object selectedColumn = null;
    private boolean DEBUG = false;
    public static final Color COLOR = new Color(143,211,211);
//    DefaultRowSorter<TableModel, String> sorter;
    
    public ReportTablePanel(){
        
        title = new JLabel("Report Table", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 32));
        title.setBorder(new EmptyBorder(-10,0,10,0));

        table = new JTable(new TableModel());
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        
        //setting Header -> add Color
        header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader h = (JTableHeader) e.getSource();
                int i = h.columnAtPoint(e.getPoint());
                Object o = h.getColumnModel().getColumn(i).getHeaderValue();
                if (i < 0f) {
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
        
//        TableRowSorter<TableModel> trs = (TableRowSorter<TableModel>) this.getRowSorter();
//        sorter = (DefaultRowSorter<TableModel, String>)table.getRowSorter();
//        for (int i=0 ; i<table.getColumnCount() ; i++) {
//            sorter.setSortable(i, false);
//        }
        
        scrollPane = new JScrollPane(table);
        
        initColumnSizes(table);
        setUpSportColumn(table, table.getColumnModel().getColumn(5));
        scrollPane.getViewport().setBackground(COLOR);
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setBorder(new EmptyBorder(30,20,20,20));
    }
    
//    public static void main(String[] args) {
//        new ReportTablePanel();
//    }
    
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
        table.getColumnModel().getColumn(1).setPreferredWidth(75);
        table.getColumnModel().getColumn(2).setPreferredWidth(125);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        
    }
    
    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Pending");
        comboBox.addItem("In progress");
        comboBox.addItem("Complete");
        
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

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
	     "Snowboarding", "14/12/22","lorem...","Pending"},
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
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}


