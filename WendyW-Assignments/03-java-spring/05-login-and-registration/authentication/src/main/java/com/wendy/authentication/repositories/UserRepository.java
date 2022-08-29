package com.wendy.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wendy.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User>findAll();
    boolean existsByEmail(String emial);
	User findByEmail(String email);
}
