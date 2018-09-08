package br.net.smi.lancamento.Lancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.smi.lancamento.Lancamento.model.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    List<Categoria> findByNomeIgnoreCaseContaining(String nome);

}