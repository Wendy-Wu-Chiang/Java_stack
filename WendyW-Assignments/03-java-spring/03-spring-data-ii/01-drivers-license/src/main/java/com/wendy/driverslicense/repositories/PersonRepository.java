package com.wendy.driverslicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wendy.driverslicense.models.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
	
	List<Person>findByLicenseIdIsNull();
}
