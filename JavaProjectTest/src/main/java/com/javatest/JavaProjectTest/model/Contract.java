package com.javatest.JavaProjectTest.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contract
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private Date startDate;
	private String typeContract;
	
	@ManyToOne //relazione 1 a n
	@JoinColumn(name="user_id") //specifico la chiave esterna(padre) 
	private User user; //riferimento al padre

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(Date startdate)
	{
		this.startDate = startdate;
	}

	public String getTypeContract() 
	{
		return typeContract;
	}

	public void setTypeContract(String typecontract)
	{
		this.typeContract = typecontract;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}
	
	
	

}
