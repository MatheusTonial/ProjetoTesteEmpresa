package projetoTeste.mapper;

import projetoTeste.dto.FuncionarioDto;
import projetoTeste.entity.Funcionario;

public class FuncionarioMapper {

	public static FuncionarioDto mapToFuncionarioDto(Funcionario funcionario) {
		return new FuncionarioDto(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSobrenome(),
				funcionario.getEmail()
				);
	}

	public static Funcionario mapToFuncionario(FuncionarioDto funcionarioDto) {
		return new Funcionario(
				funcionarioDto.getId(),
				funcionarioDto.getNome(),
				funcionarioDto.getSobrenome(),
				funcionarioDto.getEmail()
				);
	}

}
