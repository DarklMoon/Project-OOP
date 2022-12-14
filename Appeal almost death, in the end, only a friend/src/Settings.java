import java.io.Serializable;

public class Settings  implements Serializable{
    private boolean tableCreated = false;

    public void setTableCreated(boolean bool){this.tableCreated = bool;}
    public boolean getTableCreated(){return this.tableCreated; }
}
