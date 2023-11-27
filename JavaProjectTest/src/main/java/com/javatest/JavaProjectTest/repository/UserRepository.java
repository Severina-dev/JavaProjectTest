package com.javatest.JavaProjectTest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatest.JavaProjectTest.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>
{
	public List<User> findByTipology(String tipology);

	public List<User> findByFirstName(String firstName);
	

}
