package br.net.smi.lancamento.Lancamento.service;
import br.net.smi.lancamento.Lancamento.model.Categoria;
import br.net.smi.lancamento.Lancamento.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria atualizar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
        
        public Categoria buscarPeloId(Long id) {
            return categoriaRepository.findById(id).get();
        }
	
	public void deletar(Long id) {
		categoriaRepository.deleteById(id);
	}

}
