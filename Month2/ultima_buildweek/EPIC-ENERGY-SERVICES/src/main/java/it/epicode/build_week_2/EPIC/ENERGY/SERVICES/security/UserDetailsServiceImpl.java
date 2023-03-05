package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceUser;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceUserRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
    BeServiceUserRepo ur;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BeServiceUser user = ur.findByUsername(username);
        if(user != null) {
            return UserDetailsImpl.build(user);
            
        }else {
            throw new UsernameNotFoundException("User non trovato con nome:" + username);
        }
    }
}