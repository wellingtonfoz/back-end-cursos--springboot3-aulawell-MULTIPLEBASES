package app.uniamerica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.uniamerica.entity.AlunoUniamerica;
import app.uniamerica.repository.AlunoUniamericaRepository;

@Service
public class AlunoUniamericaService {
	
	@Autowired
	private AlunoUniamericaRepository alunoUniamericaRepository;

	
	public AlunoUniamerica findByRA (String ra) {
		
		Optional<AlunoUniamerica> optional = this.alunoUniamericaRepository.findByRa(ra);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}


	public List<AlunoUniamerica> findAll () {
		
		return this.alunoUniamericaRepository.findAll();
		
	}
	
	
	
}
