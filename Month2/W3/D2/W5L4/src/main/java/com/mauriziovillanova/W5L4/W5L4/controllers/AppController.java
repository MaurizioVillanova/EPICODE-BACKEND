package com.mauriziovillanova.W5L4.W5L4.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mauriziovillanova.W5L4.W5L4.config.Beans;
import com.mauriziovillanova.W5L4.W5L4.dao.DaoService;
import com.mauriziovillanova.W5L4.W5L4.entities.Role;
import com.mauriziovillanova.W5L4.W5L4.entities.User;

@Controller
public class AppController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "home page";
	}
	
	@GetMapping("/page1")
	@ResponseBody
	public String page1() {
		return "page 1";
	}
	
	@GetMapping("/page2")
	@ResponseBody
	public String page2() {
		return "page 2";
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "login success";
	}
	
	@GetMapping("/page3")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public String page3() {
		// ottieni inforamzioni sull'utente autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(authentication.getAuthorities());
		
		return "page 3";
	}
	
	@GetMapping("/page4")
	@ResponseBody
	@PreAuthorize("hasRole('USER')")
	public User page4() {
		// ottieni inforamzioni sull'utente autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User auth = dao.getUserByUsername(authentication.getName()).get();
		
		return auth;
	}
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	private DaoService dao;
	
	@GetMapping("/auth_add_user")
	@ResponseBody
	public String auth_add_user() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		User u = (User)ctx.getBean("user", 
				"Peach Pink", "ppink", pwEncoder.encode("ppink"));
		
		Set<Role> roles = new HashSet<>();
		roles.add( dao.getRoleById(2).get() );
		u.setRoles(roles);
		
		User uAdded = dao.saveUser(u);
		
		((AnnotationConfigApplicationContext)ctx).close();
		
		return (uAdded != null) ? "utente aggiunto!" : "errore!";
	}
	
	@GetMapping("/auth_update_user_pw")
	@ResponseBody
	public String auth_update_user_pw() {
		int id = 2;
		
		User u = dao.getUserById(id).get();
		String pw = u.getPassword();
		u.setPassword( pwEncoder.encode(pw) );
		dao.saveUser(u);
		
		return "utente aggiornato";
	}
	
	@GetMapping("/auth_update_user_cryptovalue1")
	@ResponseBody
	public String auth_update_user_cryptovalue1() {
		int id = 2;
		
		User u = dao.getUserById(id).get();
		u.setCryptoValue1("ananas");
		dao.saveUser(u);
		
		return "utente aggiornato";
	}
	
	@GetMapping("/getuser/{id}")
	@ResponseBody
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public User getUserById(@PathVariable(name = "id") Integer id) {
		return dao.getUserById(id).get();
	}
	
}
