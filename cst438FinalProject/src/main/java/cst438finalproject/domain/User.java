package cst438finalproject.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    private int user_id;
    private String fname;
    private String lname;
    private String email;
    private String passwd;
    
    public int getID() {
        return user_id;
     }
     
     public void setID(int user_id) {
        this.user_id = user_id;
     }
    
    public String getFname() {
        return fname;
     }
     
     public void setFname(String fname) {
        this.fname = fname;
     }
     
     public String getLname() {
        return lname;
     }
     
     public void setLname(String lName) {
        this.lname = lName;
     }
     
     public String getEmail() {
        return email;
     }
     
     public void setEmail(String email) {
        this.email = email;
     }
     
     public String getPasswd() {
         return passwd;
      }
      
      public void setPasswd(String passwd) {
         this.passwd = passwd;
      }
}
