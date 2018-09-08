package br.net.smi.lancamento.Lancamento.resource;

import br.net.smi.lancamento.Lancamento.model.Lancamento;
import br.net.smi.lancamento.Lancamento.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import javax.validation.Valid;

import java.time.LocalDate;
import br.net.smi.lancamento.Lancamento.model.LancamentoDTO;


@RestController
public class LancamentoResource {
    
@Autowired
private LancamentoService lancamentoService;

@PostMapping("/lancamento")
public ResponseEntity<Lancamento> cadastrar(@RequestBody @Valid LancamentoDTO lancamentoDTO) {
	return new ResponseEntity<>(lancamentoService.cadastrar(lancamentoDTO), HttpStatus.CREATED);
}

@PutMapping
public ResponseEntity<Lancamento> atualizar(@RequestBody Lancamento lancamento) {
	return new ResponseEntity<>(lancamentoService.atualizar(lancamento), HttpStatus.OK);
}

@GetMapping("/lancamento")
public ResponseEntity<List<Lancamento>> listar() {
    return new ResponseEntity<>(lancamentoService.listar(), HttpStatus.OK);
}

@GetMapping("/lancamento/{vencimentoInicial}/{vencimentoFinal}")
public ResponseEntity<?> listarPeloVencimento(@PathVariable("vencimentoInicial") LocalDate vencimentoInicial, @PathVariable("vencimentoFinal") LocalDate vencimentoFinal) {
    return new ResponseEntity<>(lancamentoService.buscarPeloVencimento(vencimentoInicial, vencimentoFinal), HttpStatus.OK);
}

@DeleteMapping("/lancamento/{id}")
public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
	 lancamentoService.deletar(id);
    return new ResponseEntity<>(HttpStatus.OK);
}
}
