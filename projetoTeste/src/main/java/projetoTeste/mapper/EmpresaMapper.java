package projetoTeste.mapper;

import projetoTeste.dto.EmpresaDto;
import projetoTeste.entity.Empresa;

public class EmpresaMapper {

	public static EmpresaDto mapToEmpresaDto(Empresa emp) {
		return new EmpresaDto(
				emp.getId(),
				emp.getNome()
				);
	}

	public static Empresa mapToEmpresa(EmpresaDto dto) {
		return new Empresa(
				dto.getId(),
				dto.getNome()
				);
	}
}
