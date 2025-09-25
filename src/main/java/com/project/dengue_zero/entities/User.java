package com.project.dengue_zero.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    private String uid;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "client")
    private List<Denounces> denounces = new ArrayList<>();

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
    
	public List<Denounces> getDenounces() {
		return denounces;
	} 

	@Override
	public int hashCode() {
		return Objects.hash(uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(uid, other.uid);
	}  
}