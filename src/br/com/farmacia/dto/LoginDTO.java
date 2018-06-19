package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Optional;
import java.util.function.Function;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.FarmaciaDAO;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LoginDAO;

public class LoginDTO {
	private Connection connection;
	private GenericDAO<Login> loginDAO;
	private ClienteDTO clienteDTO;

	public LoginDTO(Connection connection) {
		this.connection = connection;
		this.loginDAO = new LoginDAO(this.connection);
		this.clienteDTO = new ClienteDTO(this.connection);
	}

	/**
	 * Verifica se o cliente existe a partir do login passado
	 * 
	 * @param login
	 * @return Optional<ClientePF>
	 */
	public Optional<? extends Pessoa> validaLogin(Login login) {
		return clienteDAO.apply(login);
	}
	
	public void inserir(Login login) {
		loginDAO.inserir(login);
	}
}
