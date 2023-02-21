package com.mauriziovillanova.W5L4.W5L4.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.W5L4.W5L4.entities.Role;
import com.mauriziovillanova.W5L4.W5L4.entities.User;

@Service
public class DaoService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
	public Optional<User> getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User saveUser(User obj) {
		return userRepo.save(obj);
	}
	
	public Role saveRole(Role obj) {
		return roleRepo.save(obj);
	}
	
	public Optional<Role> getRoleById(int id) {
		return roleRepo.findById(id);
	}
	
}
