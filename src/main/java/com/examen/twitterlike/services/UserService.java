package com.examen.twitterlike.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examen.twitterlike.dtos.UserFormDTO;
import com.examen.twitterlike.models.LocalUser;
import com.examen.twitterlike.repositories.UserRepository;



@Service
public class UserService {

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
//	public List<UserDTO> getUsers() {
//		
//		List<LocalUser> users = userRepository.getUsers();
//		List<UserDTO> userDtos = new ArrayList<>();
//		
//		users.forEach((user) -> {
//			userDtos.add(new UserDTO(user.getId(), user.getUsername(), user.getRole()));
//		});
//
//		return userDtos;
//	}
	
	public void saveUser(UserFormDTO inputUser) {
		LocalUser user = new LocalUser();
		user.setUsername(inputUser.username());
		user.setPassword(passwordEncoder.encode(inputUser.password()));
		user.setRole("USER");		
		userRepository.save(user);		
	}	
}