package projetoTeste.mapper;

import projetoTeste.dto.FuncionarioDto;
import projetoTeste.entity.Empresa;
import projetoTeste.entity.Funcionario;
import projetoTeste.exception.ResourceNotFoundException;
import projetoTeste.repository.EmpresaRepository;

public class FuncionarioMapper {
	
	private static EmpresaRepository empRep;
	
	public static FuncionarioDto mapToFuncionarioDto(Funcionario funcionario) {
		
		Long idEmp = 0L;
		if(funcionario.getEmpresa() != null) {
			idEmp = funcionario.getEmpresa().getId();
		}
		
		return new FuncionarioDto(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSobrenome(),
				funcionario.getEmail(),
				idEmp
				);
	}

	public static Funcionario mapToFuncionario(FuncionarioDto funcionarioDto) {		
		Empresa emp = empRep.findById(funcionarioDto.getIdEmpresa())
				.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada, id: " + funcionarioDto.getIdEmpresa()));
		
		return new Funcionario(
				funcionarioDto.getId(),
				funcionarioDto.getNome(),
				funcionarioDto.getSobrenome(),
				funcionarioDto.getEmail(),
				emp
				);
	}

}
