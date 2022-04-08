package com.mastermeals.mastermeals.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mastermeals.mastermeals.models.Role;
import com.mastermeals.mastermeals.models.Usuario;
import com.mastermeals.mastermeals.repositories.RoleRepository;
import com.mastermeals.mastermeals.repositories.UsuarioRepository;


@Service
public class UserService {

	@Autowired
	private UsuarioRepository userRepo;
		
	@Autowired PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public void registerDefaultUser(Usuario usuario) {
		Role roleUser = roleRepo.findByNome("ROLE_USER");
		usuario.addRole(roleUser);
		encodePassword(usuario);
		if (userRepo.findByCpf(usuario.getCpf()) == null) {
			userRepo.save(usuario);
		} else {
			System.out.println("Usuario já cadastrado");
		}
	}

	private void encodePassword(Usuario usuario) {
		String encodedPassword = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPassword);
	}
}
