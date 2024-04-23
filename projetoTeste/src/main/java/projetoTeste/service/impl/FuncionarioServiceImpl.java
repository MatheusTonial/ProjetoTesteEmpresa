package projetoTeste.service.impl;

import java.beans.JavaBean;
import java.util.List;
import java.util.stream.Collectors;

import projetoTeste.dto.FuncionarioDto;
import projetoTeste.entity.Funcionario;
import projetoTeste.exception.ResourceNotFoundException;
import projetoTeste.mapper.FuncionarioMapper;
import projetoTeste.repository.FuncionarioRepository;
import projetoTeste.service.FuncionarioService;


public class FuncionarioServiceImpl implements FuncionarioService{

	private FuncionarioRepository funcionarioRepository;

	@Override
	public FuncionarioDto createFuncionario(FuncionarioDto dto) {

		Funcionario funcionario = FuncionarioMapper.mapToFuncionario(dto);
		Funcionario saveFuncionario = funcionarioRepository.save(funcionario);

		return FuncionarioMapper.mapToFuncionarioDto(saveFuncionario);
	}

	@Override
	public FuncionarioDto getFuncionarioById(Long funcionarioId) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("funcionario não encontrado, id: " + funcionarioId));

		return FuncionarioMapper.mapToFuncionarioDto(funcionario);
	}

	@Override
	public List<FuncionarioDto> getAllFuncionarios() {

		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		return funcionarios.stream()
				.map((funcionario) -> FuncionarioMapper.mapToFuncionarioDto(funcionario)).collect(Collectors.toList());
	}

	@Override
	public FuncionarioDto updateFuncionario(Long funcionarioId, FuncionarioDto dto) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado, id: " + funcionarioId));

		funcionario.setNome(dto.getNome());
		funcionario.setSobrenome(dto.getSobrenome());
		funcionario.setEmail(dto.getEmail());

		Funcionario updateFuncionario = funcionarioRepository.save(funcionario);

		return FuncionarioMapper.mapToFuncionarioDto(updateFuncionario);
	}

	@Override
	public void deleteFuncionario(Long funcionarioId) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado, id: " + funcionarioId));

		if(funcionario != null) {
			funcionarioRepository.deleteById(funcionarioId);
		}
	}
}
