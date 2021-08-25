package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Paciente;
import com.repository.PacienteRepository;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/paciente")
public class PacienteController {

	private List<Paciente> paciente = new ArrayList<>();
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@PostMapping("")
	public Paciente post(@RequestBody Paciente paciente) {
		return this.pacienteRepository.save(paciente);
	}
		
	
	@GetMapping("/{id}")
	public Paciente GetPacienteById(@PathVariable("id") Long id) {
		
		System.out.println("O id é " + id);
		Optional<Paciente> paciente1Find = paciente.stream().filter(paciente -> paciente.getId()==id).findFirst();
		
		if(paciente1Find.isPresent()) {
			return paciente1Find.get();
		}
		return null;
	}		

	
	@GetMapping("/")
	public Paciente helloWorld() {
		Paciente paciente1 = new Paciente();
		paciente1.setId(1l);
		paciente1.setName("joao");
		paciente1.setUserName("joao123");
		return paciente1;
	}
}
