package com.wendy.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.dogs.models.Toy;
import com.wendy.dogs.repositories.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository tRepo;
	
	// Create
	public Toy createToy(Toy toy) {
		return this.tRepo.save(toy);
	}
	
	// Delete
	public void deleteToy(Long id) {
		this.tRepo.deleteById(id);
	}
}
