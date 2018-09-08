package br.net.smi.lancamento.Lancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.smi.lancamento.Lancamento.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
    //Empresa findByNomeIgnoreCaseContaining(String nome);
    Empresa findByCnpj(String cnpj);
    Empresa findByNome(String nome);
	Empresa findByIdEmpresa(Long idEmpresa);
	
    
}