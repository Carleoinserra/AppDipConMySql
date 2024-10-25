package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	/*
	 * Creiamo un oggetto di tipo dipJdbcTemplate
	 */
	dipJdbcTemplate d1;
	ArrayList<dip> lista = new ArrayList<>();
	/*
	 * Questo oggetto lo iniettiamo nel controller tramite costruttore
	 */
	@Autowired
	public MyController(dipJdbcTemplate d1) {
		this.d1 = d1;
	}
	
	
	@GetMapping("/form")
	public String getForm() {
		//d1.delete("Bianchi");
		
		
		return "form";
		
	}
	/*
	 * Il metodo submit riceve i dati dal form 
	 */
	@PostMapping("/submit")
	public String getDip(@RequestParam("nome") String nome,
			@RequestParam("mansione") String mansione,
			@RequestParam("stipendio") String stipendio) {
		// chiamiamo il metodo insertDip su d1 e li passiamo i dati ottenuti dal form
		int stipendioD = Integer.parseInt(stipendio);
		d1.insertDip(nome, mansione, stipendioD);
		
		
		
		
		return "form";
	}
	
	@GetMapping("/")
	public String listaDip(Model m1) {
		
		lista = d1.getLista();
		
		m1.addAttribute("lista", lista);
		
		
		return "lista";
	}

}
