package com.example.IPCAMARKET.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.security.repository.UserRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=userRepository.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException(String.format("Usuario No encontrado con username: ", username));
		}
		else {
			return JwtuserFactory.create(user);
			
		}
		
	}
	

}
