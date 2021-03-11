package project;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity  
@Table(name= "users.accounts",uniqueConstraints={@UniqueConstraint(columnNames={"username"})})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id")

    private int id;
    @Column(name = "username")
    private String username;
    
    @Column(name = "pass")
    private String password;
    
    @Column(name = "fname")
    private String firstname;

    @Column(name = "lname")
    private String lastname;
   
    public User() {
        
    }
    
    public User(int id, String username, String firstname, String password, String lastname) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
    }
    

    public long getID() {return this.id; }
    public String getUserName() { return this.username;}
    public String getPassword() { return this.password;}
    public String getFirstName() { return this.firstname;}
    public String getLastName() { return this.lastname;}
    
    public void setId(int id) {
		this.id = id;
	}
    public void setUserName(String username) { this.username = username;}
    public void setPassword(String password) { this.password = password;}
    public void setFirstName(String firstname) { this.firstname = firstname;}
    public void setLastName(String lastname) { this.lastname = lastname;}
}