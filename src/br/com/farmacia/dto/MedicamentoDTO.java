package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.MedicamentoDAO;

public class MedicamentoDTO {
	private Connection connection;
	private GenericDAO<Medicamento> medicamentoDAO;

	public MedicamentoDTO(Connection connection) {
		this.connection = connection;
		this.medicamentoDAO = new MedicamentoDAO(this.connection);
	}

	public void inserir(Medicamento medicamento) {
		this.medicamentoDAO.inserir(medicamento);
	}

	public void alterar(Medicamento medicamento) {
		this.medicamentoDAO.alterar(medicamento);
	}

	public void excluir(Medicamento medicamento) {
		this.medicamentoDAO.excluir(medicamento);
	}

	public Optional<Collection<Medicamento>> listar() {
		return this.medicamentoDAO.listar();
	}
}
