package projetoTeste.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "email", unique = true)
	private String email;
	
	//@Nonnull
	@ManyToOne	
	@JoinColumn(name = "empresa_id", referencedColumnName = "id", nullable =  true)
	private Empresa empresa;
}
