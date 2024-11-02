package app.uniamerica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter	
@Setter	
@NoArgsConstructor	
@AllArgsConstructor
@Table(name="wiew_alunos_ativos")
public class AlunoUniamerica {
	
	@Id
	private String ra;
	
	private String nome;
	
	private String curso;
	
}
