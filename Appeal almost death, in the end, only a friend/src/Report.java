import java.util.Date;

public class Report {
    private String type, location, detail, username;
    private Date date;
    private byte[] image;

    public Report(){this("","",null,"",null,"");}
    public Report(String type,String location,Date date,String detail,byte[] image,String username){
        this.type = type;
        this.location = location;
        this.date = date;
        this.detail = detail;
        this.image = image;
        this.username = username;
    }
    
    public String getType(){return this.type;}
    public String getLocation(){return this.location;}
    public Date getDate(){return this.date;}
    public String getDetail(){return this.detail;}
    public byte[] getImage(){return this.image;}
    
    public void setType(String type){this.type = type;}
    public void setLocation(String location){this.location = location;}
    public void setDate(Date date){this.date = date;}
    public void setDetail(String detail){this.detail = detail;}
    public void setImage(byte[] image){this.image = image;}
}
