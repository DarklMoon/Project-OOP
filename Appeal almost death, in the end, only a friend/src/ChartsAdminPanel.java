import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartsAdminPanel extends JPanel{
    public static final Color COLOR = new Color(164,91,170);
    
    public ChartsAdminPanel(){
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(80, "Marks", "พื้นที่เปลี่ยว");
        dataset.setValue(50, "Marks", "พื้นที่ชำรุด");
        dataset.setValue(75, "Marks", "พื้นที่ผิดกฎหมาย");
        dataset.setValue(95, "Marks", "อบายมุข");
        dataset.setValue(10, "Marks", "ผู้กระทำผิดทางจราจร");
        dataset.setValue(45, "Marks", "สินค้าไม่ได้มาตรฐาน");
        dataset.setValue(35, "Marks", "ทุจริต/คอรัปชั่น");
        dataset.setValue(70, "Marks", "อื่นๆ");
        JFreeChart chart = ChartFactory.createBarChart3D("กราฟแสดงจำนวนการร้องเรียน", "ประเภทของการร้องเรียน", "จำนวนครั้ง", dataset, PlotOrientation.VERTICAL, false, true, false);
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
        this.add(cp,BorderLayout.CENTER);
        this.validate();
}
    }
