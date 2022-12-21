import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;


public class ChartsPanel extends JPanel{
    public static final Color COLOR = new Color(51,204,255);
    private DefaultCategoryDataset dataset;
    
    public ChartsPanel(){
        dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart3D("Graph Showing Number of Complaints", "Type of Complaints", "Number of Complaints", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(new Color(139, 188, 204));
        chart.getTitle().setPaint(Color.BLACK); 
        chart.getTitle().setFont(new Font("Sarabun", Font.BOLD, 20));
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.WHITE);

        p = (CategoryPlot)chart.getPlot();
        p.setBackgroundPaint(SystemColor.inactiveCaption);
        
        ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());

        BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, COLOR);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot= chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA");
        plot.setNoDataMessageFont(new Font("Sarabun", Font.BOLD, 30));
        plot.setNoDataMessagePaint(Color.RED);
        ChartPanel cp = new ChartPanel(chart);
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(new EmptyBorder(20,0,0,0));
        this.add(cp,BorderLayout.CENTER);
        this.setBackground(new Color(139, 188, 204));
        this.validate();
    }
    
    public DefaultCategoryDataset getDataset(){return this.dataset;}
}
