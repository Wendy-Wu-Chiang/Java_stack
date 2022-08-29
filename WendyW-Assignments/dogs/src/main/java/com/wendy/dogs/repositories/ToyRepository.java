package com.wendy.dogs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wendy.dogs.models.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long>{

}
