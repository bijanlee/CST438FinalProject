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
    private String fName;
    private String lName;
    private String email;
    private String passwd;
}
