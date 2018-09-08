package br.net.smi.lancamento.Lancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.net.smi.lancamento.Lancamento.model.Lancamento;
import br.net.smi.lancamento.Lancamento.repository.LancamentoRepository;
import br.net.smi.lancamento.Lancamento.model.LancamentoDTO;
import br.net.smi.lancamento.Lancamento.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.time.LocalDate;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EmpresaService empresaService;
	
        
	public Lancamento cadastrar(LancamentoDTO lancamentoDTO) {
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
                lancamento.setCategoria(categoriaService.buscarPeloId(lancamentoDTO.getIdCategoria()));
                lancamento.setEmpresa(empresaService.buscarPeloId(lancamentoDTO.getIdEmpresa()));
                return lancamentoRepository.save(lancamento);
	}
        
        public Lancamento atualizar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
        
        public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}
        
        public List<Lancamento> buscarPeloVencimento(LocalDate vencimentoInicial, LocalDate vencimentoFinal) {
            return lancamentoRepository.findByVencimentoBetween(vencimentoInicial, vencimentoFinal);
        }
        
        public void deletar(Long id) {
		lancamentoRepository.deleteById(id);
	}

}
