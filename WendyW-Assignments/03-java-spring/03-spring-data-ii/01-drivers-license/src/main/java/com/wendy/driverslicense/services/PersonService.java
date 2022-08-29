package com.wendy.driverslicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.driverslicense.models.Person;
import com.wendy.driverslicense.repositories.PersonRepository;

@Service
public class PersonService{
	
	@Autowired
	private PersonRepository pRepo;
	
	public List<Person>	getAllPerson(){
		return this.pRepo.findAll();
	}
	
	public Person createPerson(Person person) {
		return this.pRepo.save(person);
	}
	
	public Person getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Person>getUnlicensedPerson(){
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	public Person editPerson(Person person) {
		return this.pRepo.save(person);
	}
			
	public void deletePerson(Long id) {
		this.pRepo.deleteById(id);
	}
}
   

