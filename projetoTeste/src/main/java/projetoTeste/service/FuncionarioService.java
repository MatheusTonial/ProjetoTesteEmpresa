package projetoTeste.service;

import java.beans.JavaBean;
import java.util.List;

import projetoTeste.dto.FuncionarioDto;

public interface FuncionarioService {

	public FuncionarioDto createFuncionario(FuncionarioDto dto);

	public FuncionarioDto getFuncionarioById(Long funcionarioId);

	public List<FuncionarioDto> getAllFuncionarios();

	public FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto dto);

	public void deleteFuncionario(Long funcionarioId);

}
