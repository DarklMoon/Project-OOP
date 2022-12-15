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
    
    public ChartsPanel(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(80, "Marks", "Deserted area");
        dataset.setValue(50, "Marks", "Defective area");
        dataset.setValue(75, "Marks", "Illegal area");
        dataset.setValue(95, "Marks", "Mischief");
        dataset.setValue(10, "Marks", "Traffic offenders");
        dataset.setValue(45, "Marks", "Non-standard products");
        dataset.setValue(35, "Marks", "Fraud/Corruption");
        dataset.setValue(70, "Marks", "Other");
        JFreeChart chart = ChartFactory.createBarChart3D("Graph Showing Number of Complaints", "Type of Complaints", "Number of Complaints", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.BLACK); 
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.WHITE);

        p = (CategoryPlot)chart.getPlot();
        p.setBackgroundPaint(SystemColor.inactiveCaption);//change background color

        //set  bar chart color
        ((BarRenderer)p.getRenderer()).setBarPainter(new StandardBarPainter());

        BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0, COLOR);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot= chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA");
        plot.setNoDataMessageFont(new Font("Arial", Font.BOLD, 30));
        plot.setNoDataMessagePaint(Color.RED);
        ChartPanel cp = new ChartPanel(chart);
        this.setLayout(new java.awt.BorderLayout());
        this.setBorder(new EmptyBorder(20,0,0,0));
        this.add(cp,BorderLayout.CENTER);
        this.validate();
    }
}
