package com.javatest.JavaProjectTest.controller;

import java.util.Date;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.JavaProjectTest.model.Contract;
import com.javatest.JavaProjectTest.model.User;
import com.javatest.JavaProjectTest.repository.ContractRepository;
import com.javatest.JavaProjectTest.repository.UserRepository;



@RestController
public class Controller 
{
	@Autowired
	public UserRepository repo;
	
	@Autowired
	public ContractRepository crepo;

	
	  //insert new contracts.
	 @PostMapping("/JavaProjectTest/users/{id}/insertcontract")
	 public User insertContract(@PathVariable("id") int id,@RequestBody Contract contract)
	 {
		 User u=repo.findById(id).get();
		 u.insertContract(contract);
		 
		 return repo.save(u);
		 
	 }
	 

	 //search by: Costumer’s name
	 @GetMapping("/JavaProjectTest/users/{firstName}")
	 public ResponseEntity<User> findByFirstName(@PathVariable("firstName")String firstname)
	 {
        List<User> res=repo.findByFirstName(firstname);
		 
	 	if(!res.isEmpty())
	 	{
	 		return new ResponseEntity<User>(res.get(0),HttpStatus.OK);
	 		
	 	}
	 	else
	 	{
	 		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	 	}
	 		
		 
	 }
 
	 //search by:Date of start contract.
	 @GetMapping("/JavaProjectTest/contracts/{startDate}")
	 public List<Contract> findByStartDate(@PathVariable("startDate")Date startdate)
	 {
		 return crepo.findByStartDate(startdate);
	 }
	 
	 
	 
	 //search by:Type of contracts
	 @GetMapping("/JavaProjectTest/contracts/Type/{typeContract}")
	 public List<Contract> findByTypeContract(@PathVariable("typeContract") String typecontract)
	 {
	     return crepo.findByTypeContract(typecontract);
	 }
	 
	 
	 
	//search by:Type of users
	 @GetMapping("/JavaProjectTest/users/Type/{tipology}")
	 public List<User> findByTipology(@PathVariable("tipology") String tipology)
	 {
	     return repo.findByTipology(tipology);
	 }
	
}
