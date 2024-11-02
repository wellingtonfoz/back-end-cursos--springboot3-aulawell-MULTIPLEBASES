package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	

	public String save (Curso curso) {
		this.cursoRepository.save(curso);
		return "Curso cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Curso curso, long id) {
		curso.setId(id);
		this.cursoRepository.save(curso);
		return "Atualizado com sucesso";
	}
	
	public Curso findById (long id) {
		
		Optional<Curso> optional = this.cursoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Curso> findAll () {
		
		return this.cursoRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.cursoRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Curso> findByNome(String nome){
		return this.cursoRepository.findByNomeStartsWith(nome);
	}
	
	
}
