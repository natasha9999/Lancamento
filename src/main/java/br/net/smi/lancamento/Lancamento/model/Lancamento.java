package br.net.smi.lancamento.Lancamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.ManyToOne;



@Entity
public class Lancamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private LocalDate vencimento;
    
    @ManyToOne
    private Empresa empresa;
    
    @ManyToOne
    private Categoria categoria;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void  setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public LocalDate getVencimento() {
        return vencimento;
    }
    
    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

	public void setEmpresa(Empresa buscarPeloId) {
		
	}

	public void setCategoria(Categoria buscarPeloId) {
		
	}

}
