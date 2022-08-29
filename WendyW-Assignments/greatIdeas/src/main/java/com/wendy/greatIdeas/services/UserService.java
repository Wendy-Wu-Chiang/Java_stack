package com.wendy.greatIdeas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.greatIdeas.models.Idea;
import com.wendy.greatIdeas.models.User;
import com.wendy.greatIdeas.repositories.IdeaRepository;
import com.wendy.greatIdeas.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private IdeaRepository iRepo;

	public User registration(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public boolean authenticateUser(String email, String password) {

		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		} else {
			
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public void likeIdea(User user, Idea idea) {
		List<User> personWhoLiked = idea.getLikedUser();
		personWhoLiked.add(user);
		this.iRepo.save(idea);
	}
	
	public void unlikeIdea(User user, Idea idea) {
		List<User> personWhoLiked = idea.getLikedUser();
		personWhoLiked.remove(user);
		this.iRepo.save(idea);
	}
	
	
	
	
}
