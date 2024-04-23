package projetoTeste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoTeste.entity.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
