package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LocalizacaoDAO;

public class LocalizacaoDTO {
	private Connection connection;
	private GenericDAO<Localizacao> localizacaoDAO;
	public LocalizacaoDTO(Connection connection) {
		this.connection = connection;
		this.localizacaoDAO = new LocalizacaoDAO(this.connection);
	}
	
	public void inserir(Localizacao localizacao) {
		localizacaoDAO.inserir(localizacao);
	}
	
	public void alterar(Localizacao localizacao) {
		localizacaoDAO.alterar(localizacao);
	}
	
	public void excluir(Localizacao localizacao) {
		localizacaoDAO.excluir(localizacao);
	}
	
	public Optional<Collection<Localizacao>> listar() {
		return localizacaoDAO.listar();
	}
}
