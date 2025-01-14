package com.projetojpa.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Turma;
import com.projetojpa.repository.TurmaRepository;

@Service

public class TurmaService {

	private final TurmaRepository TurmaRepository;

	@Autowired
	public TurmaService (TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}

	public List<Turma> getAllTurma () {
		return TurmaRepository.findAll();
	}
	public Turma getTurmaById (Long id) {
		Optional<Turma> Turma = TurmaRepository.findById(id);
		return Turma.orElse(null);
	}

	public Turma saveTurma(Turma Turma) {
		return TurmaRepository.save(Turma);
	}

	public Turma putTurma(Long id, Turma alterarC) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			alterarC.setId(id);
			return TurmaRepository.save(alterarC);
		}
		return null;
	}

	public boolean deleteTurma(Long id) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			TurmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}