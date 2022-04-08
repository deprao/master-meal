package com.mastermeals.mastermeals.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mastermeals.mastermeals.models.Receita;
import com.mastermeals.mastermeals.repositories.ReceitaRepository;
import com.mastermeals.mastermeals.repositories.ReceitasRepository;

@Controller
public class ReceitasController {

	@Autowired
	ReceitasRepository rr;
			
	@Autowired
	ReceitaRepository unicaReceita;
	
	@RequestMapping(value="/buscarReceita", method=RequestMethod.GET)
	public String form(Model model) {
		List<Receita> receitas = new ArrayList<Receita>();
		model.addAttribute("receitas", new Receita());
		return("eventos/encontrarReceita");
	}
	
	@RequestMapping(value="/buscarReceita", method=RequestMethod.POST)
	public ModelAndView buscarReceita(@RequestParam(value="nome", required=false, defaultValue="") String nome) {
		//Receita receita = rr.findByIdReceita(nome);
		ModelAndView mv = new ModelAndView("eventos/encontrarReceita");
		List<Receita> receitas = new ArrayList<Receita>();
		receitas = rr.findByNome(nome);
		mv.addObject("receitas", receitas);
		return mv;
	}
	
	@RequestMapping(value="/detalhesReceita/{nome}", method=RequestMethod.GET)
	public ModelAndView detalhesReceita(@PathVariable("nome") String nome){
		Receita receita = unicaReceita.findByNome(nome);
		ModelAndView mv = new ModelAndView("eventos/detalhesReceita");
		mv.addObject("receita", receita);
	
		return mv;
	}
	
}
