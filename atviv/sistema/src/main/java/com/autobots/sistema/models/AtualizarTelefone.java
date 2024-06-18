package com.autobots.sistema.models;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Telefone;

@Component
public class AtualizarTelefone {
   
    private StringNullVerificador verificador = new StringNullVerificador();

	public void atualizar(Telefone telefone, Telefone atualizacao) {
		
        if (atualizacao != null) {
			
            if (!verificador.verificar(atualizacao.getDdd())) {
				telefone.setDdd(atualizacao.getDdd());
			}
			if (!verificador.verificar(atualizacao.getNumero())) {
				telefone.setNumero(atualizacao.getNumero());
			}
		}
	}

	public void atualizar(List<Telefone> telefones, List<Telefone> atualizacoes) {
		for (Telefone atualizacao : atualizacoes) {
			for (Telefone telefone : telefones) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == telefone.getId()) {
						atualizar(telefone, atualizacao);
					}
				}
			}
		}
	}
}
