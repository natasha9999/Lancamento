package br.net.smi.lancamento.Lancamento.resource;

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

import br.net.smi.lancamento.Lancamento.model.Empresa;
import br.net.smi.lancamento.Lancamento.service.EmpresaService;


@RestController
public class EmpresaResource {
	
@Autowired	
private EmpresaService empresaService;

@PostMapping("/empresa")
public ResponseEntity<Empresa> cadastrar(@RequestBody @Valid Empresa empresa) {
	return new ResponseEntity<>(empresaService.cadastrar(empresa), HttpStatus.OK);
}

@PutMapping("/empresa")
public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresa) {
	return new ResponseEntity<>(empresaService.atualizar(empresa), HttpStatus.OK);
}
	
@GetMapping("/empresa")
public ResponseEntity<List<Empresa>> listar() {
    return new ResponseEntity<>(empresaService.listar(), HttpStatus.OK);
}

@GetMapping("/empresa/buscarPeloNome{nome}")
public ResponseEntity<?> buscarPeloNome(@PathVariable("nome") String nome) {
    return new ResponseEntity<>(empresaService.buscarPeloNome(nome), HttpStatus.OK);
}

@GetMapping("/empresa/buscarPeloCnpj{cnpj}")
public ResponseEntity<?> buscarPeloCnpj(@PathVariable("cnpj") String cnpj) {
    return new ResponseEntity<>(empresaService.buscarPeloCnpj(cnpj), HttpStatus.OK);
}
 
 
@DeleteMapping("/empresa/{id}")
public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
	empresaService.deletar(id);
    return new ResponseEntity<>(HttpStatus.OK);
}	

}
