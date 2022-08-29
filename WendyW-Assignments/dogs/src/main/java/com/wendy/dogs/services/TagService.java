package com.wendy.dogs.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.dogs.models.Tag;
import com.wendy.dogs.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	// Create
	public Tag createTag(Tag newTag) {
		return this.tRepo.save(newTag);
	}
}