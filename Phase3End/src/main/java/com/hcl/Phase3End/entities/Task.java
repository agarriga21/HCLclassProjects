package com.hcl.Phase3End.entities;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name= "tasks")
public class Task implements Serializable {
	private static final long serialVersionUID = 2L;
	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)   
	   @Column(name = "id")
    private int id;

	@Column(name = "userid")
    private int userid;
	
	 @Column(name = "taskname")
    private String taskName;

	 @Column(name = "description")
    private String description;

	 @Column(name = "start")
    private String start;
    
	 @Column(name = "end")
    private String end;
    
	 @Column(name = "severity")
    private String severity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart() {
		
		return start;
	}

	public void setStart(String start) {
		
		this.start = start;
	}

	public String getEnd() {
		
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
    

}