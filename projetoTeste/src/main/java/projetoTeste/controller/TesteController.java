package projetoTeste.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import projetoTeste.entity.EmpresaConsulta;

@AllArgsConstructor
@RestController
@RequestMapping("/testes")
public class TesteController {

//	@PostMapping
//	public ResponseEntity<EmpresaDto> createEmpresa(@RequestBody EmpresaDto dto){
//			EmpresaDto saveEmp = service.createEntity(dto);
//
//			return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
//	}

	@GetMapping("/soma")
	public String calculaSoma(@RequestParam("valor1") double valor1, @RequestParam("valor2") double valor2) {
		double val1 = valor1;
		
		double val2 = valor2;
		
		double val3 = val1 + val2;

		return "A soma de " + val1 + " e " + val2 + " é " + val3;
	}
	
//	@GetMapping("/consulta/{cnpj}")
//    public EmpresaConsulta consultarCNPJ(@PathVariable("cnpj") String cnpj) {
//        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;
//        RestTemplate restTemplate = new RestTemplate();
//        EmpresaConsulta empresaInfo = restTemplate.getForObject(url, EmpresaConsulta.class);
//        return empresaInfo;
//    }
	
	 	@GetMapping("/consulta/{cnpj}")
	    public String consultarCNPJ(@PathVariable("cnpj") String cnpj) {
	 		//Recebe o cnpj e monta a url
	        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;
	        RestTemplate restTemplate = new RestTemplate();
	 		//faz o get no link 
	        String retorno = restTemplate.getForObject(url, String.class);
	        return retorno;
	    }

	    @GetMapping("/info/{cnpj}")
	    public String obterInfoEmpresa(@PathVariable("cnpj") String cnpj) throws IOException {
	    	// Recebe o JSON como uma string
	    	String json = consultarCNPJ(cnpj); 
	        ObjectMapper objectMapper = new ObjectMapper();
	        // Desserializa o JSON em um objeto EmpresaInfo
	        EmpresaConsulta empresaInfo = objectMapper.readValue(json, EmpresaConsulta.class); 
	     // Serializa o objeto EmpresaInfo de volta para uma string JSON
	        return objectMapper.writeValueAsString(empresaInfo); 
	    }
	
}


