package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Department {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column 
	int noofStubent; 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoofStubent() {
		return noofStubent;
	}
	public void setNoofStubent(int noofStubent) {
		this.noofStubent = noofStubent;
	}
	

	

}
