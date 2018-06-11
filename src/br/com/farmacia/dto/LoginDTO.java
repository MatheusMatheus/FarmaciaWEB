package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Optional;
import java.util.function.Function;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.ClienteDAO;

public class LoginDTO {
	private Connection connection;
	private Function<Login, Optional<ClientePF>> clienteDAO = new ClienteDAO(connection);
	public LoginDTO(Connection connection) {
			this.connection = connection;
	}
	public Optional<ClientePF> validaLogin(Login login) {
		return clienteDAO.apply(login);
	}
}
