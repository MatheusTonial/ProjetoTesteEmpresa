package projetoTeste.service;

import java.util.List;

import projetoTeste.dto.FuncionarioDto;

public interface FuncionarioService {

	public FuncionarioDto createEntity(FuncionarioDto dto);

	public FuncionarioDto getEntityById(Long funcionarioId);

	public List<FuncionarioDto> getAllEntityes();

	public FuncionarioDto updateEntity(Long funcionarioId, FuncionarioDto dto);

	public void deleteEntity(Long funcionarioId);

}
