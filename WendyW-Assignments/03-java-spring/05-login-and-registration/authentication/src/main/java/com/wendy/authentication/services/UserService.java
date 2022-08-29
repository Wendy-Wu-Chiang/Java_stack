	package com.wendy.authentication.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.authentication.models.User;
import com.wendy.authentication.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepo;
    
    
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return this.uRepo.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return this.uRepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	return this.uRepo.findById(id).orElse(null);	
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        User user = uRepo.findByEmail(email);
        if(user == null) {
            return false;
        } 
        return BCrypt.checkpw(password, user.getPassword());
    }
    
    public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	
}