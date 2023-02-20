package com.mauriziovillanova.progettosettimanale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriziovillanova.progettosettimanale.entities.User;
import com.mauriziovillanova.progettosettimanale.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository ur;

	public void addUser(User u) {
		ur.save(u);
	}

	public List<User> getAll() {
		return ur.findAll();
	}

	public User findUserById(Long id){
		return ur.findById(id).isPresent() ? ur.findById(id).get() : null;
	}
}
