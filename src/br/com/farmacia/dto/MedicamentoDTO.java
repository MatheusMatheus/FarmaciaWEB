package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.InsereMedicamento;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.InsereMedicamentoDAO;
import br.com.farmacia.modelo.dao.MedicamentoDAO;

public class MedicamentoDTO {
	private Connection connection;
	private MedicamentoDAO medicamentoDAO;
	private GenericDAO<InsereMedicamento> novoMedicamentoDAO;

	public MedicamentoDTO(Connection connection) {
		this.connection = connection;
		this.medicamentoDAO = new MedicamentoDAO(this.connection);
		this.novoMedicamentoDAO = new InsereMedicamentoDAO(this.connection);
	}
	
	public void novoCadastro(InsereMedicamento novoMedicamento, Medicamento medicamento) {
		
		// Verifica se já existe no banco um medicamento igual ao que está sendo cadastrado...
		Optional<Medicamento> med = medicamentoDAO.getBy(medicamento);
		
		if(med.isPresent() && med.get().equals(medicamento)) {
			// Caso exista, incrementa a quantidade desse medicamento 
			// no banco com a quantidade que está sendo inserida
			med.get().addMedicamentos(medicamento.getQuantidade());
			
			alterar(med.get());
		} else {
			
			inserir(medicamento);
			novoMedicamento.setId(medicamento.getId());
			this.novoMedicamentoDAO.inserir(novoMedicamento);
		}
		
	}

	private void inserir(Medicamento medicamento) {
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
