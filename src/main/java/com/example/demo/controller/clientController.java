package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.clientModel;
import com.example.demo.service.clientServiceIMPL;
import com.example.demo.utils.Constans;



@Controller
public class clientController {

	
	private clientServiceIMPL clientServiceImplement;
	
	
	@Autowired
	public clientController(clientServiceIMPL clientServiceImplement) {
		this.clientServiceImplement = clientServiceImplement;
	}



	@RequestMapping(value = "/list")
	public String findAll(Model model) {
			model.addAttribute("findAllClient", clientServiceImplement.findAll());
			return "home";
	}
	
	@PostMapping(value = "/agregarNuevo")
	public String Nuevo(@Validated clientModel client) {
		clientServiceImplement.update(client);
		return "redirect/list";
	}
}
