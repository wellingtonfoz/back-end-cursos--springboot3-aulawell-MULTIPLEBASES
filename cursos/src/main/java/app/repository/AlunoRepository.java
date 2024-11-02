package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public List<Aluno> findByNomeStartsWith(String nome);

}
