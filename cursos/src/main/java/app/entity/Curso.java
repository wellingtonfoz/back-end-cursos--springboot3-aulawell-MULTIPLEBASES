package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 	//OBRIGATÓRIO - para criar/vincular a classe Java à uma tabela do banco
@Getter		//para gerar os getters da entidade em tempo de execução
@Setter		//para gerar os setters da entidade em tempo de execução
@NoArgsConstructor	//para disponibilizar um construtor sem parâmetros
@AllArgsConstructor	//para disponibilizar um construtor com todos os parâmetros
public class Curso {
	
	@Id //OBRIGATÓRIO - para indicar que é a chave primária da respectiva tabela no BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) //OBRIGATÓRIO - para indicar que o ID autoincrementa
	private long id;
	
	@NotBlank(message = "O campo Nome do Curso não pode ser vazio!")
	private String nome;

	@ManyToOne
	private Faculdade faculdade;
	
	@ManyToMany
	@JoinTable(name="curso_aluno")
	private List<Aluno> alunos;
	
}
