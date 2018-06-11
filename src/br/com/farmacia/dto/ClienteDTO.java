package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class ClienteDTO {
	private Connection connection;
	private GenericDAO<ClientePF> clienteDAO = new ClienteDAO(connection);
	public ClienteDTO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(ClientePF cliente) {
		clienteDAO.inserir(cliente);
	}
	
	public void alterar(ClientePF cliente) {
		clienteDAO.alterar(cliente);
	}
	
	public void excluir(ClientePF cliente) {
		clienteDAO.excluir(cliente);
	}
	
	public Optional<Collection<ClientePF>> listar() {
		return clienteDAO.listar();
	}
	
}
