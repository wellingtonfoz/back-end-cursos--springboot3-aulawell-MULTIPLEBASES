package app.uniamerica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.uniamerica.entity.AlunoUniamerica;

public interface AlunoUniamericaRepository extends JpaRepository<AlunoUniamerica, String> {
	
	public Optional<AlunoUniamerica> findByRa(String ra);
	
}
