package projetoTeste.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaConsulta {
	private String uf;
    private String cep;
    private String cnpj;
    private String bairro;
    private String numero;
    private String municipio;
    private String logradouro;
    @JsonProperty("razao_social")
    private String razaoSocial;
    @JsonProperty("nome_fantasia")
    private String nomeFantasia;
    @JsonProperty("ddd_telefone_1")
    private String dddTelefone1;
    @JsonProperty("descricao_situacao_cadastral")
    private String descricaoSituacaoCadastral;

    // Getters e Setters
}
