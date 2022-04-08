package com.mastermeals.mastermeals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mastermeals.mastermeals.models.Receita;
import com.mastermeals.mastermeals.repositories.ReceitasRepository;

@Controller
public class CadastroReceitaController {

	@Autowired
	ReceitasRepository receitaRepository;
	
	@RequestMapping(value="/cadastrarReceita", method=RequestMethod.GET)
	public String form() {
		return("eventos/formCadastroReceita");
	}
	
	@RequestMapping(value="/cadastrarReceita", method=RequestMethod.POST)
	public String form(Receita receita) {
		
		receitaRepository.save(receita);
		
		return "redirect:/cadastrarReceita";
	}
	
}
