import java.util.Date;

public class Report {
    private String type, location, detail;
    private Date date;
    private Object[][] data;

    public Report(){this("","",null,"");}
    public Report(String type,String location,Date date,String detail){
        this.type = type;
        this.location = location;
        this.date = date;
        this.detail = detail;
    }
    
    public String getType(){return this.type;}
    public String getLocation(){return this.location;}
    public Date getDate(){return this.date;}
    public String getDetail(){return this.detail;}
    
    public void setType(String type){this.type = type;}
    public void setLocation(String location){this.location = location;}
    public void setDate(Date date){this.date = date;}
    public void setDetail(String detail){this.detail = detail;}
    
    public void setData(Object[][] obj){this.data = obj;}
    public Object[][] getdata(){return this.data;}
}
