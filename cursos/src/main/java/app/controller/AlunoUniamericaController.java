package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.AlunoUniamerica;
import app.service.AlunoUniamericaService;

@Validated
@RestController
@RequestMapping("/api/aluno")
@CrossOrigin("*")
public class AlunoUniamericaController {
	
	
	@Autowired
	private AlunoUniamericaService alunoUniamericaService;
	

	@GetMapping("/findByRA/{ra}")
	public ResponseEntity<AlunoUniamerica> findByRA(@PathVariable String ra){
		try {
			AlunoUniamerica alunoUniamerica = this.alunoUniamericaService.findByRA(ra);
			return new ResponseEntity<>(alunoUniamerica, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
		
	
}
