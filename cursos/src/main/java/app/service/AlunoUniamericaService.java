package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.AlunoUniamerica;
import app.repository.AlunoUniamericaRepository;

@Service
public class AlunoUniamericaService {
	
	@Autowired
	private AlunoUniamericaRepository alunoUniamericaRepository;

	
	public AlunoUniamerica findByRA (String ra) {
		
		Optional<AlunoUniamerica> optional = this.alunoUniamericaRepository.findByRA(ra);
		if(optional.isPresent()) {
			return optional.get();
		}else
			return null;
		
	}
	
	
}
