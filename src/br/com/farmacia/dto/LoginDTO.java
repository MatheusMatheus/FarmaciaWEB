package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class LoginDTO {
	private Connection connection;
	private GenericDAO<Login> loginDao;
	private Function<Login, Optional<ClientePF>> clienteDAO;
	
	public LoginDTO(Connection connection) {
			this.connection = connection;
			this.clienteDAO = new ClienteDAO(this.connection);
	}
	
	/**
	 * Verifica se o cliente existe a partir do login passado
	 * @param login
	 * @return Optional<ClientePF>
	 */
	public Optional<ClientePF> validaLogin(Login login) {
		return clienteDAO.apply(login);
	}
	
	public void inserir(Login login) {
		loginDao.inserir(login);
	}
	
	public void alterar(Login login) {
		loginDao.alterar(login);
	}
	
	public void excluir(Login login) {
		loginDao.excluir(login);
	}
	
	public Optional<Collection<Login>> listar() {
		return loginDao.listar();
	}
}
