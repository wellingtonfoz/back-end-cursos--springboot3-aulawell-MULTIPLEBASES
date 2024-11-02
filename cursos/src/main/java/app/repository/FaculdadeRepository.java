package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Faculdade;

public interface FaculdadeRepository extends JpaRepository<Faculdade, Long> {

	public List<Faculdade> findByNomeStartsWith(String nome);

}
