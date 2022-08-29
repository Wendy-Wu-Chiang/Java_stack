package com.wendy.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.dojosandninjas.models.Ninja;
import com.wendy.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	//Dependency injection
			@Autowired
			// adding the person repository as a dependency
		  	private NinjaRepository ninjaRepo;
		    
		   
		    // returns all the ninja
		    public List<Ninja> getAll() {
		        return this.ninjaRepo.findAll();
		    }
		    
		    // creates a ninja
		    public Ninja createNinja(Ninja newNinja) {
		        return ninjaRepo.save(newNinja);
		    }
		    
		    
		    //Find a ninja
		    public Ninja getSingleNinja(Long id) {
				return this.ninjaRepo.findById(id).orElse(null); //id is an optional(a boolean) (return everything or nothing)
			}
		    
		    public List<Ninja> getAll(Ninja allNinjas) {
		    	return this.ninjaRepo.findAll();
		    }
		    
		    //Update a ninja
		    public Ninja updateNinja(Ninja updatedNinja) {
		    	return this.ninjaRepo.save(updatedNinja);
		    }
		    
		    //Delete a ninja
			public void deleteById(Long id) {
		        this.ninjaRepo.deleteById(id);
		        
		    }
}
