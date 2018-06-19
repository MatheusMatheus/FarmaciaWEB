package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Optional;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LoginDAO;

public class LoginDTO {
	private Connection connection;
	private GenericDAO<Login> loginDAO;

	public LoginDTO(Connection connection) {
		this.connection = connection;
		this.loginDAO = new LoginDAO(this.connection);
	}

	/**
	 * Verifica se o cliente existe a partir do login passado
	 * 
	 * @param login
	 * @return Optional<ClientePF>
	 */
	public Optional<? extends Pessoa> validaUsuario(Login login) {
		return loginDAO.validaUsuario(login);
	}
	
	public void inserir(Login login) {
		loginDAO.inserir(login);
	}
}
