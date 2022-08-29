package com.wendy.javaPracticeOne.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name must be present!")
	@Size(max=17, message="No more than 17 letters for name,thanks!")
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@Size(min=7, message="Password must be at least 7 characters long!")
	private String password;
	

}
