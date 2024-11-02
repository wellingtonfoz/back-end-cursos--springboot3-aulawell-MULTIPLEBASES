package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	

	public String save (Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "Aluno cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Aluno aluno, long id) {
		aluno.setId(id);
		this.alunoRepository.save(aluno);
		return "Atualizado com sucesso";
	}
	
	public Aluno findById (long id) {
		
		Optional<Aluno> optional = this.alunoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Aluno> findAll () {
		
		return this.alunoRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.alunoRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Aluno> findByNome(String nome){
		return this.alunoRepository.findByNomeStartsWith(nome);
	}
	
	
}
