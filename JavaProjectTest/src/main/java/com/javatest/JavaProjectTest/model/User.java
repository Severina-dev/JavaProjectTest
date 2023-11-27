package com.javatest.JavaProjectTest.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String tipology;
	
	
	@OneToMany
	(
			mappedBy="user",
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL //cascade->opzione di propagazione di una operazione
	)
	private List<Contract> contracts; //lista dei contratti..figli di User
	
	//quando caricherò un user caricherò anche i suoi contratti
	
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstname) 
	{
		this.firstName = firstname;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastname)
	{
		this.lastName = lastname;
	}
	
	
	public String getTipology()
	{
		return tipology;
	}
	public void setTipology(String tipology)
	{
		this.tipology = tipology;
	}
	public List<Contract> getContracts()
	{
		return contracts;
	}
	public void setContracts(List<Contract> contracts)
	{
		this.contracts = contracts;
	}
	
	public void insertContract(Contract contract)
	{
		//collego il figlio al padre
		contract.setUser(this);
		//collego il padre al figlio
		contracts.add(contract);
	}
	
	
}
