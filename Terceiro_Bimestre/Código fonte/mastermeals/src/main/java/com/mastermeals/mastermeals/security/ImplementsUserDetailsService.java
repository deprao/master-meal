package com.mastermeals.mastermeals.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.mastermeals.mastermeals.models.Usuario;
import com.mastermeals.mastermeals.repositories.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = ur.findByCpf(cpf);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado"); 
		}
		return new CustomUserDetails(usuario);
	}

}
