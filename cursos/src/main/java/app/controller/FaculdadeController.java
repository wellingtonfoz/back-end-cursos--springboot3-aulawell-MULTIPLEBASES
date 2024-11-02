package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Faculdade;
import app.service.FaculdadeService;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/faculdade")
@CrossOrigin("*")
public class FaculdadeController {
	
	
	@Autowired
	private FaculdadeService faculdadeService;
	

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Faculdade faculdade){
		try {
			String mensagem = this.faculdadeService.save(faculdade);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("dsklfjsdl");
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @RequestBody Faculdade faculdade, @PathVariable long id){
		try {
			String mensagem = this.faculdadeService.update(faculdade, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Faculdade> findById(@PathVariable long id){
		try {
			Faculdade faculdade = this.faculdadeService.findById(id);
			return new ResponseEntity<>(faculdade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Faculdade>> findAll(){
		try {
			List<Faculdade> lista = this.faculdadeService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.faculdadeService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Faculdade>> findByNome(@RequestParam String nome){
		try {
			List<Faculdade> lista = this.faculdadeService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
	
}
