package com.autobots.sistema.models;

import com.autobots.sistema.entities.Cliente;

public class AtualizarCliente {
    private StringNullVerificador verificador = new StringNullVerificador();
	private AtualizarEndereco enderecoAtualizador = new AtualizarEndereco();
	private AtualizarDocumento documentoAtualizador = new AtualizarDocumento();
	private AtualizarTelefone telefoneAtualizador = new AtualizarTelefone();

	private void atualizarDados(Cliente cliente, Cliente atualizacao) {
		if (!verificador.verificar(atualizacao.getNome())) {
			cliente.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getNomeSocial())) {
			cliente.setNomeSocial(atualizacao.getNomeSocial());
		}
		if (!(atualizacao.getDataCadastro() == null)) {
			cliente.setDataCadastro(atualizacao.getDataCadastro());
		}
		if (!(atualizacao.getDataNascimento() == null)) {
			cliente.setDataNascimento(atualizacao.getDataNascimento());
		}
	}

	public void atualizar(Cliente cliente, Cliente atualizacao) {
		atualizarDados(cliente, atualizacao);
		enderecoAtualizador.atualizar(cliente.getEndereco(), atualizacao.getEndereco());
		documentoAtualizador.atualizar(cliente.getDocumentos(), atualizacao.getDocumentos());
		telefoneAtualizador.atualizar(cliente.getTelefones(), atualizacao.getTelefones());
	}
}
