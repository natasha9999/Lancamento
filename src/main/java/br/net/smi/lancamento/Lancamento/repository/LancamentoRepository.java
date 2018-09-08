package br.net.smi.lancamento.Lancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

import br.net.smi.lancamento.Lancamento.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
    
 List<Lancamento> findByVencimentoBetween(LocalDate vencimentoInicial, LocalDate vencimentoFinal);
}