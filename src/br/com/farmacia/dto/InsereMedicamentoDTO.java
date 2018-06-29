package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;

import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.dao.InsereMedicamentoDAO;

public class InsereMedicamentoDTO {
	private Connection connection;
	private InsereMedicamentoDAO medicamentoDAO;

	public InsereMedicamentoDTO(Connection connection) {
		this.connection = connection;
		this.medicamentoDAO = new InsereMedicamentoDAO(this.connection);
	}
	
	public Collection<Medicamento> getMedicamentos(FarmaciaPJ farmacia) {
		return this.medicamentoDAO.getBy(farmacia).orElse(Collections.emptyList());
	}
}
