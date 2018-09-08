package br.net.smi.lancamento.Lancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.net.smi.lancamento.Lancamento.model.Empresa;
import br.net.smi.lancamento.Lancamento.repository.EmpresaRepository;
import java.util.List;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa cadastrar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
        
        public Empresa atualizar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
        
        public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
        
        public Empresa buscarPeloNome(String nome) {
            return empresaRepository.findByNome(nome);
        }
        
        public Empresa buscarPeloCnpj(String cnpj) {
            return empresaRepository.findByCnpj(cnpj);
        }
        
        public void deletar(Long id) {
    		empresaRepository.deleteById(id);
    	}

		public Empresa buscarPeloId(Long idEmpresa) {
			return empresaRepository.findByIdEmpresa(idEmpresa);
		}

		
}
