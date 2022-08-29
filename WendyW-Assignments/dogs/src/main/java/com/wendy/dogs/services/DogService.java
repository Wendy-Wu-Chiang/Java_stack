package com.wendy.dogs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wendy.dogs.models.Dog;
import com.wendy.dogs.repositories.DogRepository;

@Service
public class DogService {
	private final DogRepository dRepo;
	
	public DogService(DogRepository repo) {
		this.dRepo = repo;
	}
	
	// Display All Dogs
	public List<Dog> getAllDogs(){
		return this.dRepo.findAll();
	}
	
	// Display One Dog
	public Dog getSingleDog(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	// Create Dog
	public Dog createDog(Dog dog) {
		return this.dRepo.save(dog);
	}
	
	//Create Dog Manual Way
	public Dog createDogTwo(String name, String breed, int age) {
		Dog newDog = new Dog(name, breed, age);
		return this.dRepo.save(newDog);
	}
	
	// Delete Dog
	public void deleteDog(Long id) {
		this.dRepo.deleteById(id);
	}
	
	// Update Dog
	public Dog updateDog(Dog dog) {
		return this.dRepo.save(dog);
	}

}
