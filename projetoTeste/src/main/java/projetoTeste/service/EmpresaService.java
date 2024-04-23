package projetoTeste.service;

import java.util.List;

import projetoTeste.dto.EmpresaDto;

public interface EmpresaService {

	public EmpresaDto createEntity(EmpresaDto dto);

	public EmpresaDto getEntityById(Long id);

	public List<EmpresaDto> getAllEntityes();

	public EmpresaDto updateEntity(Long id, EmpresaDto dto);

	public void deleteEntity(Long id);
}
