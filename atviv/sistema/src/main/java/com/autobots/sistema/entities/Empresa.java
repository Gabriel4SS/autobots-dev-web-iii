package com.autobots.sistema.entities;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Empresa extends RepresentationModel<Empresa>{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String razaoSocial;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @Column
	private Date cadastro;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Servico> servicos;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Mercadoria> mercadorias;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Venda> vendas;

}
