package com.project.dengue_zero.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	
    @Id
    private String uid;
    
    private String name;
    private String email;

    public User() {
    }

    public User(String uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }

    public String getUid() {
    	return uid; 
    }
    
    public void setUid(String uid) {
    	this.uid = uid; 
    }

    public String getName() {
    	return name; 
    }
    
    public void setName(String name) {
    	this.name = name; 
    }
   
    public String getEmail() {
    	return email; 
    }
    
    public void setEmail(String email) {
    	this.email = email; 
    }
}