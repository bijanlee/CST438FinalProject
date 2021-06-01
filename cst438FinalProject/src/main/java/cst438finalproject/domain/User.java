package cst438finalproject.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    private int ID;
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String passwd;
    private Reservation reservations;
}
