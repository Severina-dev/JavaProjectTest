package com.javatest.JavaProjectTest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatest.JavaProjectTest.model.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract,Integer>
{

	public List<Contract> findByStartDate(Date date);
	public List<Contract> findByTypeContract(String typeContract);

	
}
