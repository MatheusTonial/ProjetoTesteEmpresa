package projetoTeste.service.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projetoTeste.dto.EmpresaDto;
import projetoTeste.entity.Empresa;
import projetoTeste.exception.ResourceNotFoundException;
import projetoTeste.mapper.EmpresaMapper;
import projetoTeste.repository.EmpresaRepository;
import projetoTeste.service.EmpresaService;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService{

	private EmpresaRepository empRep;

	@Override
	public EmpresaDto createEntity(EmpresaDto dto) {

		Empresa emp = EmpresaMapper.mapToEmpresa(dto);
		Empresa saveEmp = empRep.save(emp);

		return EmpresaMapper.mapToEmpresaDto(saveEmp);
	}

	@Override
	public EmpresaDto getEntityById(Long id) {

		Empresa emp = empRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada, id: " + id));

		return EmpresaMapper.mapToEmpresaDto(emp);
	}

	@Override
	public List<EmpresaDto> getAllEntityes() {

		List<Empresa> emps = empRep.findAll();
		return emps.stream()
				.map((empresa) -> EmpresaMapper.mapToEmpresaDto(empresa)).collect(Collectors.toList());
	}

	@Override
	public EmpresaDto updateEntity(Long id, EmpresaDto dto) {

		Empresa emp = empRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada, id: " + id));

		emp.setNome(dto.getNome());

		Empresa updateEmp = empRep.save(emp);

		return EmpresaMapper.mapToEmpresaDto(updateEmp);
	}

	@Override
	public void deleteEntity(Long id) {

		Empresa emp = empRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada, id: " + id));

		if(emp != null) {
			empRep.deleteById(id);
		}

	}
}
