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

import com.projetojpa.entities.Aluno;
import com.projetojpa.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/aluno")

public class AlunoController {

private final AlunoService AlunoService;
	
	@Autowired
	public AlunoController (AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Aluno> getAlunoControlId (@PathVariable Long id) {
		Aluno Aluno = AlunoService.getAlunoById(id);
		if (Aluno != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Aluno>> getAllAlunoControl () {
		List<Aluno> Aluno = AlunoService.getAllAluno();
		return ResponseEntity.ok(Aluno);
}
	
	
	@PostMapping
	public ResponseEntity <Aluno> saveAlunoControl(@RequestBody @Valid Aluno Aluno) {
		Aluno saveAluno = AlunoService.saveAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAluno);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Aluno> putAlunoControl(@PathVariable Long id, @RequestBody @Valid Aluno Aluno){
		Aluno putAluno = AlunoService.putAluno(id, Aluno);
		if (putAluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Aluno> deleteAlunoControl (@PathVariable Long id) {
		boolean delete = AlunoService.deleteAluno(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}