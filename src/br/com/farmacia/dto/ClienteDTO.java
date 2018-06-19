package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class ClienteDTO {
	private Connection connection;
	private GenericDAO<ClientePF> clienteDAO;
	public ClienteDTO(Connection connection) {
		this.connection = connection;
		this.clienteDAO = new ClienteDAO(this.connection);
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
	
	public ClientePF getCliente() {
		
		return ClienteDAO.
	}
	
}
