package com.mastermeals.mastermeals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/n")
	public String index() {
		return "index";
	}
}
