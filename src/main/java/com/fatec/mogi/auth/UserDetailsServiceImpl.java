package com.fatec.mogi.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Comprador;
import com.fatec.mogi.repository.CompradorRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CompradorRepository compradorRepository;
	
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Comprador comprador = compradorRepository.findByLogin(username);
        if (comprador == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(comprador.getLogin(), comprador.getSenha(), Collections.emptyList());
    }
	
	
}
