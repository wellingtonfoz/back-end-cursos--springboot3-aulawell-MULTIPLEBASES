package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	public List<Curso> findByNomeStartsWith(String nome);

}
