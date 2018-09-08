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

import br.net.smi.lancamento.Lancamento.model.Categoria;
import br.net.smi.lancamento.Lancamento.service.CategoriaService;
import java.util.List;

import javax.validation.Valid;



@RestController
public class CategoriaResouce {
@Autowired

private CategoriaService categoriaService;

@PostMapping("/categoria")
public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid Categoria categoria) {
	return new ResponseEntity<>(categoriaService.cadastrar(categoria), HttpStatus.CREATED);
}

@PutMapping
public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
	return new ResponseEntity<>(categoriaService.atualizar(categoria), HttpStatus.OK);
}

@GetMapping("/categoria")
public ResponseEntity<List<Categoria>> listar() {
    return new ResponseEntity<>(categoriaService.listar(), HttpStatus.OK);
}

@DeleteMapping("/categoria/{id}")
public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
	 categoriaService.deletar(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

}