package com.autobots.sistema.models;

import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Endereco;

@Component
public class AtualizarEndereco {
    
    private StringNullVerificador verificador = new StringNullVerificador();

    public void atualizar(Endereco endereco, Endereco atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getEstado())) {
				endereco.setEstado(atualizacao.getEstado());
			}
			if (!verificador.verificar(atualizacao.getCidade())) {
				endereco.setCidade(atualizacao.getCidade());
			}
			if (!verificador.verificar(atualizacao.getBairro())) {
				endereco.setBairro(atualizacao.getBairro());
			}
			if (!verificador.verificar(atualizacao.getRua())) {
				endereco.setRua(atualizacao.getRua());
			}
			if (!verificador.verificar(atualizacao.getNumero())) {
				endereco.setNumero(atualizacao.getNumero());
			}
			if (!verificador.verificar(atualizacao.getInfoAdicionais())) {
				endereco.setInfoAdicionais(atualizacao.getInfoAdicionais());
			}
		}
	}
}
