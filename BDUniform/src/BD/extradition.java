package BD;
import java.sql.Date;
public class extradition {
    private int idExtradition;
    private int idEmployee;
    private int idUniform;
    private Date dateIssue;

    public extradition(int idExtradition, int idEmployee, int idUniform, Date dateIssue) {
        this.idExtradition = idExtradition;
        this.idEmployee = idEmployee;
        this.idUniform = idUniform;
        this.dateIssue = dateIssue;
    }

    
    public int getIdExtradition() { return idExtradition; }
    public int getIdEmployee() { return idEmployee; }
    public int getIdUniform() { return idUniform; }
    public Date getDateIssue() { return dateIssue; }
}