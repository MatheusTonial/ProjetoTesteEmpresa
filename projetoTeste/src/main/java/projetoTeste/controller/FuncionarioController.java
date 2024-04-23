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
import projetoTeste.dto.FuncionarioDto;
import projetoTeste.service.FuncionarioService;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private FuncionarioService service;

	@PostMapping
	public ResponseEntity<FuncionarioDto> createFuncionario(@RequestBody FuncionarioDto dto){
		FuncionarioDto saveFuncionario = service.createFuncionario(dto);

		return new ResponseEntity<>(saveFuncionario, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<FuncionarioDto> getFuncionarioById(@PathVariable("id") Long funcionarioId){
		FuncionarioDto funcionarioDto = service.getFuncionarioById(funcionarioId);

		return ResponseEntity.ok(funcionarioDto);
	}

	@GetMapping
	public ResponseEntity<List<FuncionarioDto>> getAllFuncionarios(){
		List<FuncionarioDto> funcionarios = service.getAllFuncionarios();

		return ResponseEntity.ok(funcionarios);
	}

	@PutMapping("{id}")
	public ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable("id") Long funcionarioId, @RequestBody FuncionarioDto dto){
		FuncionarioDto updateDto = service.updateFuncionario(funcionarioId, dto);

		return ResponseEntity.ok(updateDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable("id") Long  funcionarioId){

		service.deleteFuncionario(funcionarioId);

		return ResponseEntity.ok("Funcionario deletado");

	}

}
