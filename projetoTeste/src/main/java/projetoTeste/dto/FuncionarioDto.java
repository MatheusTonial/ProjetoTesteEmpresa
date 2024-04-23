package projetoTeste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projetoTeste.entity.Empresa;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto {

	private Long id;

	private String nome;

	private String sobrenome;

	private String email;
	
	//private Empresa empresa;
	
	private Long idEmpresa;

}
