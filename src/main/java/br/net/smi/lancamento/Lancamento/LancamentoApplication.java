package br.net.smi.lancamento.Lancamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.net.smi.lancamento.Lancamento.model.Lancamento;


@SpringBootApplication
public class LancamentoApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lancamento.class, args);
    }
} 