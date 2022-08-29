package com.wendy.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.dojosandninjas.models.Dojo;
import com.wendy.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	//Dependency injection
	@Autowired
	// adding the person repository as a dependency
  	private DojoRepository dojoRepo;
    
   
    // returns all the dojo
    public List<Dojo> getAll() {
        return this.dojoRepo.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo newDojo) {
        return dojoRepo.save(newDojo);
    }
    
    
    //Find a Dojo
    public Dojo getSingleDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null); //id is an optional(a boolean) (return everything or nothing)
	}
    
    //Update a Dojo
    public Dojo updateDojo(Dojo updatedDojo) {
    	return this.dojoRepo.save(updatedDojo);
    }
    
    //Delete a dojo
	public void deleteById(Long id) {
        this.dojoRepo.deleteById(id);
        
    }
}
