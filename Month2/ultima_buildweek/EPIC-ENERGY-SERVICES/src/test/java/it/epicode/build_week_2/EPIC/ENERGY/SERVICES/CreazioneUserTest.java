package it.epicode.build_week_2.EPIC.ENERGY.SERVICES;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller.BeServiceUserController;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceRoleRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceUserRepo;

@SpringBootTest
class CreazioneUserTest {
	
	private BeServiceUserRepo userRepo;
	private BeServiceRoleRepo roleRepo;
	private PasswordEncoder passwordEncoder;
	private BeServiceUserController controller;
	
	@BeforeEach
	public void setup() {
		userRepo = mock(BeServiceUserRepo.class);
		roleRepo = mock(BeServiceRoleRepo.class);
        passwordEncoder = mock(PasswordEncoder.class);
        controller = new BeServiceUserController(userRepo, roleRepo, passwordEncoder);

	}
	/*
	@Test
	//testa la creazione dello user
	public void testAddUser() throws Exception {
		BeServiceUser user = new BeServiceUser();
        user.setEmail("test@test.com");
        user.setUsername("testuser");
        user.setPassword("testpassword");

        when(userRepo.findByEmail(user.getEmail())).thenReturn(null);
        when(userRepo.findByUsername(user.getUsername())).thenReturn(null);
        when(roleRepo.findByRoleName(RoleType.ROLE_USER)).thenReturn(new BeServiceRole());

        Set<BeServiceRole> userRoles = new HashSet<>();
        userRoles.add(new BeServiceRole());
        user.setBeServiceRole(userRoles);

        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedpassword");

        ResponseEntity<?> response = controller.addUser(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Utente registrato correttamente", response.getBody());
    }*/


}
