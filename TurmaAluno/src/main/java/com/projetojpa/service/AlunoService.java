package com.projetojpa.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Aluno;
import com.projetojpa.repository.AlunoRepository;

@Service
public class AlunoService {

		private final AlunoRepository AlunoRepository;

		@Autowired
		public AlunoService (AlunoRepository AlunoRepository) {
			this.AlunoRepository = AlunoRepository;
		}

		public List<Aluno> getAllAluno () {
			return AlunoRepository.findAll();
		}
		public Aluno getAlunoById (Long id) {
			Optional<Aluno> Aluno = AlunoRepository.findById(id);
			return Aluno.orElse(null);
		}

		public Aluno saveAluno(Aluno Aluno) {
			return AlunoRepository.save(Aluno);
		}

		public Aluno putAluno(Long id, Aluno alterarC) {
			Optional <Aluno> existeAluno = AlunoRepository.findById(id);
			if (existeAluno.isPresent()) {
				alterarC.setId(id);
				return AlunoRepository.save(alterarC);
			}
			return null;
		}

		public boolean deleteAluno(Long id) {
			Optional <Aluno> existeAluno = AlunoRepository.findById(id);
			if (existeAluno.isPresent()) {
				AlunoRepository.deleteById(id);
				return true;
			}
			return false;
		}
	}