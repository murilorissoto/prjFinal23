package com.example.senai.PrjFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.senai.PrjFinal.entities.Finalgame;
import com.example.senai.PrjFinal.service.FinalgameService;

@RestController
@RequestMapping("/jogo")
public class FinalgameController {

	
	@Autowired
	private final FinalgameService finalgameService;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}

	@Autowired
	public FinalgameController(FinalgameService finalgameService) {
		this.finalgameService = finalgameService;
	}
	
	 @PostMapping("/create")
	    public Finalgame createFinalgame(@RequestBody Finalgame finalgame) {
		 return finalgameService.saveFinalgame(finalgame);
	    }
	

	@GetMapping("/{id}")
	public ResponseEntity<Finalgame> getFinalgame(@PathVariable Long id) {
		Finalgame finalgame = finalgameService.getFinalgameById(id);
		if (finalgame != null) {
			return ResponseEntity.ok(finalgame);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<Finalgame> getAllFinalgame() {
		return finalgameService.getAllFinalgame();
	}

	@DeleteMapping("/{id}")
	public void deleteFinalgame(@PathVariable Long id) {
		finalgameService.deleteFinalgame(id);
	}	}
