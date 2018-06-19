package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.dao.FarmaciaDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class FarmaciaDTO {
	private Connection connection;
	private GenericDAO<FarmaciaPJ> farmaciaDAO;
	public FarmaciaDTO(Connection connection) {
		this.connection = connection;
		this.farmaciaDAO = new FarmaciaDAO(this.connection);
	}
	
	public void inserir(FarmaciaPJ farmacia) {
		this.farmaciaDAO.inserir(farmacia);
	}
	
	public void alterar(FarmaciaPJ farmacia) {
		this.farmaciaDAO.alterar(farmacia);
	}
	
	public void excluir(FarmaciaPJ farmacia) {
		this.farmaciaDAO.excluir(farmacia);
	}
	
	public Optional<Collection<FarmaciaPJ>> listar() {
		return this.farmaciaDAO.listar();
	}
}
