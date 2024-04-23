package projetoTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoTeste.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
