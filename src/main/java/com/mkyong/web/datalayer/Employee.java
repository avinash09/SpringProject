package com.mkyong.web.datalayer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	
	public static String ID = "id";
	
	public static String NAME = "name";
	
	public static String AGE = "age";
	
	public static String CREATEDATE = "createdate";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Double age;
	
	@Column(nullable=false)
	private Date createdate;
	
	@Column(nullable=false)
	private Date modidate;
	
	public Employee() {
		super();
	}

	public Employee(String name, Double age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}
	
	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.id+" "+this.name+" "+this.age+" "+this.createdate+" "+this.modidate+"]";
	}

}
