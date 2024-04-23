package projetoTeste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import projetoTeste.dto.EmpresaDto;
import projetoTeste.service.EmpresaService;

@AllArgsConstructor
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	private EmpresaService service;

	@PostMapping
	public ResponseEntity<EmpresaDto> createEmpresa(@RequestBody EmpresaDto dto){
			EmpresaDto saveEmp = service.createEntity(dto);

			return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmpresaDto> getEmpresaById(@PathVariable("id") Long empId){
		EmpresaDto empDto = service.getEntityById(empId);

		return ResponseEntity.ok(empDto);
	}

	@GetMapping
	public ResponseEntity<List<EmpresaDto>> getAllEmpresas(){
		List<EmpresaDto> emps = service.getAllEntityes();

		return ResponseEntity.ok(emps);
	}

	@PutMapping("{id}")
	public ResponseEntity<EmpresaDto> updateEmpresa(@PathVariable("id") Long empId, @RequestBody EmpresaDto dto){
		EmpresaDto updateDto = service.updateEntity(empId, dto);

		return ResponseEntity.ok(updateDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmpresa(@PathVariable("id") Long empId){

		service.deleteEntity(empId);

		return ResponseEntity.ok("Empresa deletada");
	}
}
