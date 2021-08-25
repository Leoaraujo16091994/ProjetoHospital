package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Primeira;
import com.repository.PrimeiraRepository;

@RestController
@RequestMapping("/primeira")

public class PrimeiraController {

	private List<Primeira> primeira = new ArrayList<>();
	
	@Autowired
	private PrimeiraRepository primeiraRepository;	
	
	@GetMapping("/{id}")
	public Primeira primeira(@PathVariable("id") Long id) {
		
		System.out.println("O id é " + id);
		Optional<Primeira> teste1Find = primeira.stream().filter(primeira -> primeira.getId()==id).findFirst();
		
		if(teste1Find.isPresent()) {
			return teste1Find.get();
		}
		return null;
	}
	
		
	
	@GetMapping("/")
	public Primeira helloWorld() {
		
		Primeira teste1 = new Primeira();
		teste1.setId(1l);
		teste1.setName("joao");
		teste1.setUserName("joao123");
		return teste1;
	}
	
	
	@PostMapping("/")
	public Primeira post(@RequestBody Primeira parametro) {
		return this.primeiraRepository.save(parametro);
		//primeira.add(parametro);
		//return parametro;
	}
	

}
