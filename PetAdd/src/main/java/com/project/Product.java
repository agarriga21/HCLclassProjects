package com.project;

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
@Table(name= "pets.products")

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id")

    private int id;
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "color")
    private String color;

   
    public Product() {
        
    }
    
    public Product(int id, String name, String color, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.color = color;
    }
    

    public long getID() {return this.id; }
    public String getName() { return this.name;}
    public BigDecimal getPrice() { return this.price;}
    public String getColor() { return this.color;}
    
    public void setId(int id) {
		this.id = id;
	}
    public void setName(String name) { this.name = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setColor(String color) { this.color = color;}
}
