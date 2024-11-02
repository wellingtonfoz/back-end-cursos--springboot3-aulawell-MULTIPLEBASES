package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Faculdade;
import app.repository.FaculdadeRepository;

@Service
public class FaculdadeService {
	
	@Autowired
	private FaculdadeRepository faculdadeRepository;
	

	public String save (Faculdade faculdade) {
		this.faculdadeRepository.save(faculdade);
		return "Faculdade cadastrado com sucessodsfadsfsd";
	}
	
	public String update (Faculdade faculdade, long id) {
		faculdade.setId(id);
		this.faculdadeRepository.save(faculdade);
		return "Atualizado com sucesso";
	}
	
	public Faculdade findById (long id) {
		
		Optional<Faculdade> optional = this.faculdadeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	public List<Faculdade> findAll () {
		
		return this.faculdadeRepository.findAll();
		
	}
	
	public String delete (long id) {
		this.faculdadeRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}
	
	
	public List<Faculdade> findByNome(String nome){
		return this.faculdadeRepository.findByNomeStartsWith(nome);
	}
	
	
}
