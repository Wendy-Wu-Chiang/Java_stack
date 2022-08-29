package com.wendy.eventsbeltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendy.eventsbeltreviewer.models.Message;
import com.wendy.eventsbeltreviewer.repositories.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository mRepo;
	
	public List<Message> getAllMessages() {
		return this.mRepo.findAll();
	}
	
	public Message addMessage(Message message) {
		return this.mRepo.save(message);
	}
	
}