package com.jbk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer eid;
	private String name;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
	}

	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + "]";
	}
	

}
