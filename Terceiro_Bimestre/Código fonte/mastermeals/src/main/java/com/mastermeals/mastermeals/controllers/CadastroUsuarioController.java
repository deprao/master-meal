package com.mastermeals.mastermeals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mastermeals.mastermeals.models.Usuario;
import com.mastermeals.mastermeals.repositories.UsuarioRepository;
import com.mastermeals.mastermeals.security.UserService;

@Controller
public class CadastroUsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("usuario", new Usuario());
		return("eventos/formCadastro");
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String form(@Validated Usuario usuario, BindingResult resultado, RedirectAttributes redirectAttributes) {
		if(resultado.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarUsuario";
		}
		service.registerDefaultUser(usuario);
		redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso!");
		return "redirect:/buscarReceita";
	}
	
	
	@RequestMapping(value="/buscarReceita")
	public String inicio() {
		return ("eventos/encontrarReceita");
	}

}
