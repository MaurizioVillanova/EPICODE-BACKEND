package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceRole;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceUser;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.RoleType;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceRoleRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceUserRepo;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class BeServiceUserController {
	@Autowired
	BeServiceUserRepo br;
	
	@Autowired
	BeServiceRoleRepo rr;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping(path="/crea/user", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addUser(@ModelAttribute BeServiceUser user, HttpServletResponse httpServletResponse) throws IOException {
	    //Controllo se l'utente esiste già
	    if(br.findByEmail(user.getEmail()) != null) {
	        return ResponseEntity.badRequest().body("Utente Gia Registrato con questa email");
	    } else if(br.findByUsername(user.getUsername()) != null) {
	        return ResponseEntity.badRequest().body("Username già utilizzato");
	    }

	    BeServiceRole userRole = rr.findByRoleName(RoleType.ROLE_USER);
	    Set<BeServiceRole> userRoles = new HashSet<>();
	    userRoles.add(userRole);
	    user.setBeServiceRole(userRoles);
	    
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    br.save(user);
	    
	    // Redirect to the logged-in page after successful registration
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://localhost:8080/login");
	    redirectView.setExposeModelAttributes(false);
	    httpServletResponse.sendRedirect(redirectView.getUrl());
	    
	    return ResponseEntity.ok("Utente registrato correttamente");
	}

	
	/*@RequestMapping(value = "/crea/user",method = RequestMethod.POST)
	 public ResponseEntity<?> register(@ModelAttribute("user") BeServiceUser user, Model model) {
		 if(br.findByEmail(user.getEmail()) != null) {
	            return ResponseEntity.badRequest().body("Utente Gia Registrato con questa email");
	        }else if(br.findByUsername(user.getUsername())!= null){
	            return ResponseEntity.badRequest().body("Username già utilizzato");
	        }
		 BeServiceRole userRole = rr.findByRoleName(RoleType.ROLE_USER);
	        Set<BeServiceRole> userRoles = new HashSet<>();
	        userRoles.add(userRole);
	        user.setBeServiceRole(userRoles);
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);
	  br.save(user);
	  return ResponseEntity.ok("Utente registrato correttamente");
	 }*/
  
	

}
