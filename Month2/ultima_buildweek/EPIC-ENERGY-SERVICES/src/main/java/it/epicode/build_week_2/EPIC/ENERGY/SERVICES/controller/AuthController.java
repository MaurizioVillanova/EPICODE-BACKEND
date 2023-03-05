package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceRoleRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceUserRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.security.JwtUtils;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.security.UserDetailsImpl;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.security.response.JwtResponse;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.security.response.LoginRequest;


@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	BeServiceUserRepo us;
	@Autowired
	BeServiceRoleRepo roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	
}
