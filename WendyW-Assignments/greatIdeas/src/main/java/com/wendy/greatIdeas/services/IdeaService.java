package com.wendy.greatIdeas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.greatIdeas.models.Idea;
import com.wendy.greatIdeas.repositories.IdeaRepository;

@Service
public class IdeaService {

	@Autowired
	private IdeaRepository iRepo;
	
	public List<Idea> getAllIdeas(){
		return this.iRepo.findAll();
	}
	
	public Idea getOneIdea(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}

	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}

	public Idea updateIdea(Idea idea) {
		return this.iRepo.save(idea);
	}

	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	
	
	
	
}
