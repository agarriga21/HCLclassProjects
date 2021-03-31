package com.hcl.Phase3End.entities;

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
@Table(name= "users",uniqueConstraints={@UniqueConstraint(columnNames={"username"})})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)   
   @Column(name = "id")

    private Integer id;
   @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;

   
   
    public User() {
        
    }
    
    public User(Integer id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.email = email;
           
    }
    

    public Integer getID() {return this.id; }
    public String getUserName() { return this.username;}
    public String getPassword() { return this.password;}
    public String getEmail() { return this.email;}
    
    
    public void setId(Integer id) {
		this.id = id;
	}
    public void setUserName(String username) { this.username = username;}
    public void setPassword(String password) { this.password = password;}
    public void setEmail(String email) { this.email = email;}
    
    
}