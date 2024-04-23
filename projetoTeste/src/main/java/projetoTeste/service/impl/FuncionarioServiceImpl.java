package projetoTeste.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projetoTeste.dto.FuncionarioDto;
import projetoTeste.entity.Funcionario;
import projetoTeste.exception.ResourceNotFoundException;
import projetoTeste.mapper.FuncionarioMapper;
import projetoTeste.repository.EmpresaRepository;
import projetoTeste.repository.FuncionarioRepository;
import projetoTeste.service.FuncionarioService;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

	private FuncionarioRepository funcionarioRepository;
	private EmpresaRepository empRep;

	@Override
	public FuncionarioDto createEntity(FuncionarioDto dto) {

		Funcionario funcionario = FuncionarioMapper.mapToFuncionario(dto);
		Funcionario saveFuncionario = funcionarioRepository.save(funcionario);

		return FuncionarioMapper.mapToFuncionarioDto(saveFuncionario);
	}

	@Override
	public FuncionarioDto getEntityById(Long funcionarioId) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("funcionario não encontrado, id: " + funcionarioId));

		return FuncionarioMapper.mapToFuncionarioDto(funcionario);
	}

	@Override
	public List<FuncionarioDto> getAllEntityes() {

		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		return funcionarios.stream()
				.map((funcionario) -> FuncionarioMapper.mapToFuncionarioDto(funcionario)).collect(Collectors.toList());
	}

	@Override
	public FuncionarioDto updateEntity(Long funcionarioId, FuncionarioDto dto) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado, id: " + funcionarioId));

		funcionario.setNome(dto.getNome());
		funcionario.setSobrenome(dto.getSobrenome());
		funcionario.setEmail(dto.getEmail());
		funcionario.setEmpresa(empRep.findById(dto.getIdEmpresa())
				.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada, id: " + dto.getIdEmpresa())));

		Funcionario updateFuncionario = funcionarioRepository.save(funcionario);

		return FuncionarioMapper.mapToFuncionarioDto(updateFuncionario);
	}

	@Override
	public void deleteEntity(Long funcionarioId) {

		Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado, id: " + funcionarioId));

		if(funcionario != null) {
			funcionarioRepository.deleteById(funcionarioId);
		}
	}
}
