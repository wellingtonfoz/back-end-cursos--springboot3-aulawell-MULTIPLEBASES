package app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.AlunoUniamerica;

public interface AlunoUniamericaRepository extends JpaRepository<AlunoUniamerica, Long> {
	
	public Optional<AlunoUniamerica> findByRA(String ra);
	
}
