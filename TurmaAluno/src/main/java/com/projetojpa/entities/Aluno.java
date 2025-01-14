package com.projetojpa.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = false)
	private Long id;
	
	private String cidade;
	
	private String email;
	
	private String nome;
	
	private String ra;
	
	private double renda;
	
	private String telefone;
	
	private double id_turma;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_turma",nullable = false, insertable=false, updatable=false)
	private Turma turma;
}
