package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Turma;
import com.projetojpa.service.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/turma")

public class TurmaController {

private final TurmaService TurmaService;
	
	@Autowired
	public TurmaController (TurmaService TurmaService) {
		this.TurmaService = TurmaService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Turma> getTurmaControlId (@PathVariable Long id) {
		Turma Turma = TurmaService.getTurmaById(id);
		if (Turma != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Turma>> getAllTurmaControl () {
		List<Turma> Turma = TurmaService.getAllTurma();
		return ResponseEntity.ok(Turma);
}
	
	
	@PostMapping
	public ResponseEntity <Turma> saveTurmaControl(@RequestBody @Valid Turma Turma) {
		Turma saveTurma = TurmaService.saveTurma(Turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTurma);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Turma> putTurmaControl(@PathVariable Long id, @RequestBody @Valid Turma Turma){
		Turma putTurma = TurmaService.putTurma(id, Turma);
		if (putTurma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Turma> deleteTurmaControl (@PathVariable Long id) {
		boolean delete = TurmaService.deleteTurma(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}