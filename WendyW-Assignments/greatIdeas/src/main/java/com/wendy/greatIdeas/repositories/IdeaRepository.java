package com.wendy.greatIdeas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wendy.greatIdeas.models.Idea;

public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();

}
